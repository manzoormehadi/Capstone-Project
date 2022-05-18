import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { DashboardService } from '../dashboard.service';
import { FavouriteService } from '../favourite.service';
import { RestaurantDetails } from '../RestaurantDetails';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private dashboardService: DashboardService, private userService: UserserviceService,
    private router: Router, private favouriteService: FavouriteService) { }

  public user: User = new User();
  public restaurantDetails: RestaurantDetails = new RestaurantDetails();

  public mail: any = '';
  public collection_id: any = '';
  public title: String = '';
  public url: String = '';
  public restaurantList: RestaurantDetails[];
  public list: any;
  public q: any;

  ngOnInit(): void {
    scrollTo(0,0);
    this.getcollections();
  }

  getcollections(): any {
    this.dashboardService.getLocation().subscribe(
      (data) => {
        this.list = data['best_rated_restaurant'];
        console.log(data['best_rated_restaurant']);
      },
      (error) => {
        Swal.fire('Error in Fetching Data :(')
        console.log(error);

      });

  }
 res1(res: any) {
    console.log(res)

    localStorage.setItem("restaurantidnew", res.restaurant.R.res_id);
    this.router.navigate(['/ReviewPage']);
  }
  res2(){
    this.router.navigate(['/ReviewPage']);
  }
}
