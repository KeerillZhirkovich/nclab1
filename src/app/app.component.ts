import {Component, NgModule, OnInit} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@NgModule({
  imports: [
    BrowserModule,
    // import HttpClientModule after BrowserModule.
    HttpClientModule,
  ],
  declarations: [
    AppComponent,
  ],
  bootstrap: [AppComponent]
})

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'My first AGM project';
  lat = 53.203358;
  lng = 50.146048;

  currentLocation: string;
  neededLocation: string;
  consumption = 10; // расход
  tripPrice: number; // возврат с сервера
  searchLocation: string; // строка поиска
  cityCode = 51; // шлется с сервера. ищется по названию города в файле citiesForWeather
  weatherPath = 'https://clck.yandex.ru/redir/dtype=stred/pid=7/cid=1228/*https://yandex.ru/pogoda/' + this.cityCode;
  weatherImgPath = 'https://info.weather.yandex.net/' + this.cityCode + '/4_white.ru.png?domain=ru';

  calcUrl = '/data/calcTripPrice';
  searchUrl = '/data/';
  getCodeUrl = '/data/';

  constructor(private http: HttpClient){}

  ngOnInit() {
    console.log('cL' + this.currentLocation);
  }

  getCityCode() {// возврат кода города для информера
    const object = {neededLocation: this.neededLocation};
    this.http.post(this.getCodeUrl, JSON.stringify(object)
    ).subscribe((data) => {
      this.cityCode = JSON.parse(data.toString());
    });
  }

  calc() {// отправка расхода, принятие  стоимости
    const object = {current: this.currentLocation, needed: this.neededLocation, consumption: this.consumption};
    this.http.post(this.calcUrl, JSON.stringify(object)
    ).subscribe((data) => {
      this.tripPrice = JSON.parse(data.toString());
    });
  }

  search() {// отрправка города, получение координат
    const object = {search: this.searchLocation};
    this.http.post(this.searchUrl, JSON.stringify(object)
    ).subscribe((data) => {
      const cords: Cords = JSON.parse(data.toString());
      this.lat = cords.lat;
      this.lng = cords.lng;
    });
  }
}
interface Cords {
  lat: number;
  lng: number;
}
