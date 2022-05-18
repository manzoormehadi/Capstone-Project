import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Favourites } from './favourites';

@Injectable({
  providedIn: 'root'
})
export class FavouriteService {

  private BASE_URL= 'http://localhost:9508';
  constructor(private http: HttpClient) { }

   //post operation
 saveFavourites(fav: Favourites): any{
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };
  return this.http.post(`${this.BASE_URL}/api/v1/favouriteservice/addfav`, fav);
}

  //get operation
  getAllFavorites(loggedInUser:any): Observable<any>{
    return this.http.get(`${this.BASE_URL}/api/v1/favouriteservice/getAllFavourites/${loggedInUser}`);
  }

  //delete operation
  deleteFavourites(favId: any): Observable<any>{
    return this.http.delete(`${this.BASE_URL}/api/v1/favouriteservice/${favId}`);
  }
}
