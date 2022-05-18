import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { DashboardService } from '../dashboard.service';
import { RestaurantDetails } from '../RestaurantDetails';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { FavouriteService } from '../favourite.service';
import { Favourites } from '../favourites';
import { Review } from '../review';
import { ReviewServiceService } from '../review.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private dashboardService: DashboardService, private userService: UserserviceService,
    private router: Router, private favouriteService: FavouriteService,
    private reviewService: ReviewServiceService) { }

  public user: User = new User();
  public restaurantDetails: RestaurantDetails = new RestaurantDetails();
  public review: Review = new Review();;
  public res_id: any = 0;
  public mail: any = '';
  public collection_id: any = '';
  public title: String = '';
  public url: String = '';
  public restaurantList: RestaurantDetails[];
  public list: any;
  public q: any;

  newfav: Favourites = new Favourites();
  ngOnInit(): void {
    scrollTo(0,0);
    this.getcollections();
  }

  getcollections(): any {
    this.dashboardService.getLocation().subscribe(
      (data) => {
        this.list = data['best_rated_restaurant'];
        console.log(data['best_rated_restaurant']);
        console.log(this.title);

      },
      (error) => {
        Swal.fire('Error in Fetching Data :(')
        console.log(error);

      });
  }

  saveFavourites(fav: any) {

    console.log(fav)
    this.newfav.loggedInUser = localStorage.getItem("loggedInUser");
    this.newfav.restaurantId = fav.restaurant.R.res_id;
    this.newfav.restaurantName = fav.restaurant.name;
    this.newfav.address = fav.restaurant.location.address;
    this.favouriteService.saveFavourites(this.newfav).subscribe(data => {
      console.log(data);
      Swal.fire("Successfully Added to Favorites!");
    }), (
        error => {
          //Swal.fire("Already Exists In Favorites!");
          console.log(error)
        }
      )
  }

  res(res: any) {
    console.log(res)

    localStorage.setItem("restaurantid", res.restaurant.R.res_id);
    this.router.navigate(['/Review']);
  }

  logout() {

    this.user.username = localStorage.getItem("loggedInUser");
    this.user.email = localStorage.getItem("email");
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



