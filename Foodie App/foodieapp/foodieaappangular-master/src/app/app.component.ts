import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { DashboardService } from './dashboard.service';
import { User } from './user';
import { UserserviceService } from './userservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FoodieAppangular';
  email='';
  constructor( private userService: UserserviceService, private router: Router) { }

  public user: User = new User();


 




}
