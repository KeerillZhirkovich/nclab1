import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title: string = 'My first AGM project';
  lat: number = 53.203358;
  lng: number = 50.146048;

  currentLocation: string ;
  neededLocation: string ;
  consumption: number = 10;//расход
  tripPrice: number ;//возврат с сервера
  searchLocation: string;//строка поиска
  cityCode: number = 51;//шлется с сервера. ищется по названию города в файле citiesForWeather 
  weatherPath = "https://clck.yandex.ru/redir/dtype=stred/pid=7/cid=1228/*https://yandex.ru/pogoda/"+this.cityCode;
  weatherImgPath = "https://info.weather.yandex.net/"+this.cityCode+"/4_white.ru.png?domain=ru";
  
  calcUrl = "/data/calcTripPrice";
  searchUrl = "/data/";
  getCodeUrl = "/data/";
  
  //constructor(private http: HttpClient){}
  
  ngOnInit(){
	  console.log("cL"+this.currentLocation);
  }
  
 getCityCode(){//возврат кода города для информера
		let object = {neededLocation: this.neededLocation}
		this.http.post(this.getCodeUrl, JSON.stringify(object)
		).subscribe((data)=>{this.cityCode = data})
  }
  
  calc(){// отправка расхода, принятие  стоимости
		let object = {current: this.currentLocation, needed: this.neededLocation, consumption: this.consumption}
		this.http.post(this.calcUrl, JSON.stringify(object)
		).subscribe((data)=>{this.tripPrice = data})
	}
	
	search(){// отрправка города, получение координат
		let object = {search: this.searchLocation}
		this.http.post(this.searchUrl, JSON.stringify(object)
		).subscribe((data) => {
			this.lat=data.lat; 
			this.lng=data.lng
			})
	}
  }
  
