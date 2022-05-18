import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Review } from './review';

@Injectable({
  providedIn: 'root'
})
export class ReviewServiceService {

  private BASE_URL = 'http://localhost:9501/api/v1/review';

  constructor(private http: HttpClient) { }
  addReview(review: Review): any{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    return this.http.post(`${this.BASE_URL}/addreview/`+review.restaurantId, review);
  }

  getReview(restaurantId:String): Observable<any>{
    return this.http.get(`${this.BASE_URL}/` +restaurantId);
  }

  updateReview(review: Review): Observable<any>{
    return this.http.put(`${this.BASE_URL}/updatereview/{restaurantId}`,review);
  }

  deleteReview(review: Review): Observable<any>{
    return this.http.put(`${this.BASE_URL}/deletereview/{restaurantId}`,review);
  }

  deleteAllReview(review: Review): Observable<any>{
    return this.http.put(`${this.BASE_URL}/deleteall/{restaurantId}`,review);
  }
}
