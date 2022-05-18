import { Component,Output,EventEmitter,OnInit } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css']
})
export class StarRatingComponent implements OnInit {
  @Output() parentFunction:EventEmitter<any>=new EventEmitter();

  stars: number[] = [1, 2, 3, 4, 5];
  public selectedValue: number;
  constructor() { }
  ngOnInit() {
    
  }
 
  countStar(star) {
    this.selectedValue = star;
    console.log('Value of star', this.selectedValue);
    this.sendData();
  }
  addClass(star) {
    let ab = "";
    for (let i = 0; i < star; i++) {
      ab = "starId" + i;
      document.getElementById(ab).classList.add("selected");
    }
 }
 removeClass(star) {
    let ab = "";
    for (let i = star-1; i >= this.selectedValue; i--) {
      ab = "starId" + i;
      document.getElementById(ab).classList.remove("selected");
    }
 }
 sendData(){
  let data = this.selectedValue;
  this.parentFunction.emit(data);
}

}
