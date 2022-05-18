import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { throwToolbarMixedModesError } from '@angular/material/toolbar';
import { Track } from '../data/track';
import { TrackService } from '../services/track.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  constructor(private trackservice:TrackService,private _snackBar: MatSnackBar) { }

  trackList:any= [];
  tra: Track;

  ngOnInit(): void {
    this.getAllTracks();
    console.log('trackist'+this.trackList);
  }
  getAllTracks() {
    
    this.trackservice.getFavourites(localStorage.getItem('userloggedin')).subscribe((res) => {
      
     this.trackList = res.json();
    })
  }

   removefromfavorite(track: Track): any {

    
    track.loggedInUser=localStorage.getItem('userloggedin');
    this.trackservice.removefromfavorite(track.id).subscribe(
      (data) => {
        this.getAllTracks();
        this._snackBar.open("Track Removed",'',{
          duration: 1000
         });
      }
    );
  } 

}
