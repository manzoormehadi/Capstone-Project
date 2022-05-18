import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private userService: UserserviceService, private _router: Router) { }

  public user: User = new User();

  public username: string = '';
  public mobileno: string = '';
  public email: string = '';
  public password: string = '';
  public validate: string;
  public message: string;
  public userlist = [];
  ngOnInit(): void {
    this.getAllUsers();
  }

  register(frm): any {

    this.user.username = frm.username;
    this.user.mobileno = frm.mobileno;
    this.user.email = frm.email;
    this.user.password = frm.password;
    this.email = frm.email;

    if ((!this.user.username) || (!this.user.email) || (!this.user.password) || (!this.user.mobileno)) {
      alert("Fill all details");
    }
    else {
      this.userService.register(this.user).subscribe(
        (data: any) => {
          console.log(data)
        },
        (error: any) => {
          console.log(error)
          if (error.status == 409) {
            this.myalert("Email/Username already exists")
          }
          else {
            this.myalert("Registered succesfully")
            this._router.navigate(['/Login'])
          }
        });
      this.clear();
    }
  }

  clear(): any {
    this.username = '';
    this.email = '';
    this.mobileno = '';
    this.password = '';
  }

  getAllUsers(): any {
    this.userService.getAllUsers().subscribe(
      (data) => {
        this.userlist = data;
      });
  }

  getUser(user: string): any {
    this.userService.getUser(user).subscribe(
      (data) => {
        this.userlist = [];
        this.userlist.push(data)
      });
  }

  myalert(msg: string) {
    Swal.fire(msg)
  }
}

