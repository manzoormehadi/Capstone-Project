import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../data/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  status: boolean;
  user: User = new User();

  constructor(private route: ActivatedRoute, private router: Router, private userservice: UserService,private _snackBar: MatSnackBar) { }


  ngOnInit(): void {

  }


  routetologin(): void{
    this.router.navigate(['/login']);
  }

  signup(signupForm: any): void {

    this.user.username = signupForm.username;
    this.user.password = signupForm.password;
    this.user.email = signupForm.email;
    this.user.mobileno = signupForm.mobile;
    
    console.log(this.user);
    this.userservice.addUser(this.user).subscribe(
      data => {
        this._snackBar.open("Registration Successful",'',{
          duration: 2000
         });
          this.router.navigate(['/login']);
      },
      (err)=>
      {
        this._snackBar.open("Registration Not Successful",'',{
          duration: 10000
         });
      }

    );
  }





}
