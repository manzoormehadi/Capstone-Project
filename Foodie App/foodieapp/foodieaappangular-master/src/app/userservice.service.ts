import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {User} from './user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  //backend connection url setting
  private BASE_URL = 'http://localhost:8088';

  constructor(private http: HttpClient) { }

  //post operation
  register(user: User): any{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    return this.http.post(`${this.BASE_URL}//api/v1/user/adduser`, user);
  }

  getAllUsers(): Observable<any>{
    return this.http.get(`${this.BASE_URL}/api/v1/user`);
  }
  getUser(email:string): Observable<any>{
    return this.http.get(`${this.BASE_URL}/api/v1/{email}`);
  }

  public  login( user: User ):any {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    
    return this.http.put(`${this.BASE_URL}/api/v1/user/login`, user,httpOptions);
  }

  public logoutUser( user: User ):any {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };

    console.log(user);
    return this.http.put(`${this.BASE_URL}/api/v1/user/logout`, user,httpOptions)

  }
}
