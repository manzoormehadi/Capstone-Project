import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Track } from '../data/track';
import { TrackService } from '../services/track.service';
@Component({
  selector: 'app-recommend',
  templateUrl: './recommend.component.html',
  styleUrls: ['./recommend.component.css']
})
export class RecommendComponent implements OnInit {
  constructor(private trackservice:TrackService,private _snackBar: MatSnackBar) { }
  trackList:any= [];
  tra: Track;
  ngOnInit(): void {
    this.getAllTracks();
    console.log('trackist'+this.trackList);
  }
  getAllTracks() {
    this.trackservice.getRecommend(localStorage.getItem('userloggedin')).subscribe((res) => {
     this.trackList = res.json();
    })
  }
   removefromrecommended(track: Track): any {
    track.loggedInUser=localStorage.getItem('userloggedin');
    this.trackservice.removefromrecommend(track.id).subscribe(
      (data) => {
        this.getAllTracks();
        this._snackBar.open("Track Removed",'',{
          duration: 1000
         });
      }
    );
  } 
}
