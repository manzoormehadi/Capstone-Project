import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { doesNotReject } from 'assert';
import Swal from 'sweetalert2';

import { FavouriteService } from '../favourite.service';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {

  public favList: any[] = [];
  loggedInUser = '';
  email = '';
  user2 = new User();


  public user: User = new User();
  constructor(private favouritesService: FavouriteService, private router: Router, private userService: UserserviceService) { }

  ngOnInit(): void { 
    scrollTo(0,0);
    this.getAllFavorites(); 
    
  }

  getAllFavorites(): any {

    this.loggedInUser = localStorage.getItem("loggedInUser")
    this.email = localStorage.getItem("email")
    console.log(this.email)
    this.favouritesService.getAllFavorites(this.loggedInUser).subscribe(data => {
      this.favList = data;
      console.log(this.favList);
    });
  }

  deleteFavourites(fav: any): any {

    var result = confirm("Are sure you want to delete this favorite ?");
    if (result) {
      this.favouritesService.deleteFavourites(fav.restaurantId).subscribe(data => {
        console.log(this.favList);
        Swal.fire("Successfully Deleted!");
      });
      location.reload();
      Swal.fire("Successfully Deleted!");
    }
  }

  logout() {

    this.user.username = this.loggedInUser
    this.user.email = this.email
    this.user.password = localStorage.getItem("password");
    this.userService.logoutUser(this.user).subscribe(
      data => {
        console.log(data);


      },
      (error: any) => {
        console.log(error)
        if (error.status == 401) {
          Swal.fire('Unauthorised :(')
        }
        else if (error.status == 400) {
          Swal.fire('Bad Request :(')
        }
        else if (error.status == 200) {
          Swal.fire('See you soon!')
        }
        else {
          Swal.fire('Bad request :(')
        }
      }


    );
    var empty = "";
    localStorage.setItem("loggedInUser", empty);
    localStorage.setItem("email", empty);
    localStorage.setItem("password", empty);
    this.router.navigate(['/Login']);
  }

}
