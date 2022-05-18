import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { Http, Headers} from '@angular/http';
import { User } from '../data/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  public USER_SERVICE_BASE_URL = 'http://localhost:9010/api/v1/user';

  constructor(private http: Http) { }

  addUser(user: User): any{
    return this.http.post(`${this.USER_SERVICE_BASE_URL}/adduser`, user);
  }

  login(user: User): any{
    console.log("User : "+user);
    return this.http.put(`${this.USER_SERVICE_BASE_URL}/login`, user);
  }

}
