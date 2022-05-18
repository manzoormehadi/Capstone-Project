import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User = new User();
  public user2: User = new User();
  public username = '';
  public password = '';

  constructor(private _service: UserserviceService, private _router: Router) { }
  ngOnInit(): void {
    scrollTo(0,0);
  }

  loginUser(loginForm: any): void {
    // console.log(loginForm)
    this.user.username = loginForm.username;
    this.user.password = loginForm.password;
    this._service.login(this.user).subscribe(
      data => {
        console.log(data);
        this.user2 = data;
        Swal.fire('Login successfull :)')
        console.log("Login successfull");
        localStorage.setItem("loggedInUser", this.user.username);
        localStorage.setItem("email", data.email);
        localStorage.setItem("password", data.password);
        console.log(localStorage.getItem("loggedInUser"));
        console.log(localStorage.getItem("currentuser"))
        this._router.navigate(['/Dashboard']);
        

      },
      (error: any) => {
        console.log(error)
        if (error.status == 401) {
          Swal.fire('No such User :(')
        }
        else if (error.status == 400) {
          Swal.fire('Bad Request :(')
        }

        else if (error.status == 409) {
          Swal.fire('User Already Logged In!')
        }

        else {
          Swal.fire('Incorrect Data :(')
        }

      });
  }

  clear() {
    this.username = '';
    this.password = '';
  }
}


