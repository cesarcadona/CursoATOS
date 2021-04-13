import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicoService {

  constructor(private http:HttpClient) { }


  public getTimeNow():Observable<any>{

    return this.http.get('http://localhost:8080/util/');
  }

}
