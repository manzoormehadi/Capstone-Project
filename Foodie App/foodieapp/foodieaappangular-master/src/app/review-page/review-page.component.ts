import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Review } from '../review';
import { ReviewServiceService } from '../review.service';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-review-page',
  templateUrl: './review-page.component.html',
  styleUrls: ['./review-page.component.css']
})
export class ReviewPageComponent implements OnInit {
  constructor(
    public reviewService: ReviewServiceService,
    private router: Router,
    private userService: UserserviceService
  ) { }

  public user: User = new User()
  public review: Review = new Review();
  public reviewList: any;
  public restaurantId = localStorage.getItem("restaurantid");
  public q;

  ngOnInit(): void {
    scrollTo(0,0);
    this.getReviews();

  }
  parentFunction(data) {
    console.log(data);
    this.review.reviewRating = data;

  }
  reviews(): any {
    this.review.userEmail = localStorage.getItem("email");
    this.review.restaurantId = localStorage.getItem("restaurantid");
    console.log(this.review.userEmail);
    console.log(this.review.restaurantId);

    console.log(this.review.reviewContent);
    console.log(this.review.reviewRating);

    if ((!this.review.reviewContent) || (!this.review.reviewRating) || (!this.review.userEmail)) {
      alert("Please fill the required fields!");
    }
    else {
      this.reviewService.addReview(this.review).subscribe(
        (data: any) => {
          console.log(data)
        },
        (error: any) => {
          console.log(error)
          if (error.status == 409) {
            Swal.fire('Review Already Exist :(')
          }
          else if (error.status == 400) {
            Swal.fire('Bad Request :(')
          }

          else {
            Swal.fire('Review Added Successfully :)')
            this.router.navigate(['/Review'])
          }
        });
    };
  }
  clear(): any {
    this.review.reviewContent = '';
    this.review.reviewRating = 0;
    this.review.userEmail = '';

  }
  getReviews(): any {
    this.review.restaurantId = localStorage.getItem("restaurantidnew");
    this.reviewService.getReview(this.review.restaurantId).subscribe(
      (data: any) => {
        console.log(data)

        this.reviewList = data['review'];
        console.log(this.reviewList);
      }
    );
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
