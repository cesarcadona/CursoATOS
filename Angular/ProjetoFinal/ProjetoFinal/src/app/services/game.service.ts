import { User } from './../models/user';
import { Game } from '../models/game';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { uri } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GameService{

  private apiUrl = `${uri.baseUri}/game`;
  // private token:string;

  constructor(private http: HttpClient) { }

  // public setToken(token:string){
  //   this.token = token;
  // }



  public getGames(user:User) : Observable<Game[]>{
    return this.http.post<Game[]>(`${this.apiUrl}/get/all`, user,{headers:{

      Authorization: `Bearer ${localStorage.getItem('token')}`
    }});
  }

  public addGame(game:Game): Observable<Game>{
    return this.http.post<Game>(`${this.apiUrl}/add`, game, {headers:{
      Authorization:`Bearer ${localStorage.getItem('token')}`
    }});
  }

  public updateGame(game:Game): Observable<Game>{
    return this.http.put<Game>(`${this.apiUrl}/update`, game, {headers:{
      Authorization:`Bearer ${localStorage.getItem('token')}`
    }});
  }

  public deleteGame(gameId:number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/delete/${gameId}`,{headers:{
      Authorization:`Bearer ${localStorage.getItem('token')}`
    }});
  }
}
