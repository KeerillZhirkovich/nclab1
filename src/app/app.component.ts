import { Component, OnInit } from '@angular/core';
//import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title: string = 'My first AGM project';
  lat: number = 53.203358;
  lng: number = 50.146048;

  currentLocation: string = "Samara";
  neededLocation: string = "Moscow";
  consumption: number = 10;
  tripPrice: number = 20000;
  
  //constructor(private http: HttpClient){}
  
  ngOnInit(){
	  console.log("cL"+this.currentLocation);
  }
  
  calc(){
	  console.log("cL"+this.currentLocation);
	 /* this.http.get({"current": currentLocation, "needed": neededLocation, "consumption": consumption})
	  .subscribe((data) => this.tripPrice=data);*/
	 /* this.service.simpleGet('data', '/getConsumtion', {current:currentLocation,needed:neededLocation }).subscribe(response => { 
		const data = response.data; 
		tripPrice: data.price;
		}); */
}
  }
  
