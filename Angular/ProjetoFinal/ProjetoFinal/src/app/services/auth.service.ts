import { User } from './../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { uri } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUserUrl = `${uri.baseUri}/user`;

  authenticatedUser:User;
  isLoogedIn = JSON.parse(localStorage.getItem('isLogged') || 'false');

  constructor(private http:HttpClient) { }


  register(data): Observable<any>{
    return this.http.post(`${this.apiUserUrl}/register`, data, {responseType:'text' as 'json'});
  }

  login(data): Observable<string>{
    return this.http.post<string>(`${this.apiUserUrl}/authenticate`, data,{responseType:'text' as 'json'});
  }

  getUser(data): Observable<any>{
    return this.http.post(`${this.apiUserUrl}/getUser`,data ,{ headers:{
      Authorization: `Bearer ${localStorage.getItem('token')}`
    }});
  }
}
