import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Track } from '../data/track';
import { Http} from '@angular/http';
@Injectable({
  providedIn: 'root'
})
export class TrackService {

  public USER_SERVICE_BASE_URL = 'http://localhost:9011/api/v1/favouriteservice';

  constructor(private http: Http) { }

  getTracks(): Observable<any> {
    return this.http.get('http://api.napster.com/v2.2/tracks/top?apikey=YTkxZTRhNzAtODdlNy00ZjMzLTg0MWItOTc0NmZmNjU4Yzk4');
  }

  addFavorites(track:Track): Observable<any> {
    console.log(track);
    return this.http.post(`${this.USER_SERVICE_BASE_URL}`, track);
  }


  getFavourites(loginUser:string): Observable<any> {
    
    return this.http.get(`http://localhost:9011/api/v1/favouriteservice/getAllFavourites/${loginUser}`);
  }


  
  removefromfavorite(trackid:string): any {

    return this.http.delete(`${this.USER_SERVICE_BASE_URL}/${trackid}`);
  }

  getRecommend(loginUser:string): Observable<any> {
    return this.http.get(`http://localhost:9020/api/v1/recommendservice/getAllRecommended/${loginUser}`);
  }
  removefromrecommend(trackid:string): any {
    return this.http.delete(`http://localhost:9020/api/v1/recommendservice/${trackid}`);
  }

  addRecommend(track:Track): Observable<any> {
    console.log(track);
    return this.http.post(`http://localhost:9020/api/v1/recommendservice`, track);
  }

}