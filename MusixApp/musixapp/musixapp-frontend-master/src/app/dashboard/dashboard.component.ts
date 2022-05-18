import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Track } from '../data/track';
import { TrackService } from '../services/track.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  constructor(private trackservice:TrackService,private _snackBar: MatSnackBar) { }
  trackList:any= [];
  tra: Track;
  ngOnInit(): void {
    this.getAllTracks();
  }
  getAllTracks() {
    this.trackservice.getTracks().subscribe((res) => {
      this.trackList = res.json()['tracks'];
    }, (error) => {
      console.log(error);
    })
  }
  addtofavorite(track: Track): any {
    track.loggedInUser=localStorage.getItem('userloggedin');
    this.trackservice.addFavorites(track).subscribe(
      (data) => {
        this.getAllTracks();
        this._snackBar.open("Track Added",'',{
          duration: 1000
         });
      }
    );
  }
  addtorecommend(track: Track): any {
    track.loggedInUser=localStorage.getItem('userloggedin');
    this.trackservice.addRecommend(track).subscribe(
      (data) => {
        this.getAllTracks();
        this._snackBar.open("Track Added",'',{
          duration: 1000
         });
      }
    );
  }
}
