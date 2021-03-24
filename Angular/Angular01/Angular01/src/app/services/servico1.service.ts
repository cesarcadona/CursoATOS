import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class Servico1Service {



  constructor(private http:HttpClient) {

  }

  public getPhotos():Observable<any>{
    return this.http.get('https://jsonplaceholder.typicode.com/photos');
  }
  public getAlbuns():Observable<any>{
    return this.http.get('https://jsonplaceholder.typicode.com/albums');
  }
}
