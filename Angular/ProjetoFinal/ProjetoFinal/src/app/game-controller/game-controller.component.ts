import { Game } from './../models/game';
import { User } from './../models/user';
import { AuthService } from './../services/auth.service';
import { NgForm } from '@angular/forms';
import { GameService } from './../services/game.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-game-controller',
  templateUrl: './game-controller.component.html',
  styleUrls: ['./game-controller.component.css']
})

export class GameControllerComponent implements OnInit {

  public games: Game[] = [];

  public editGame: Game;

  public deleteGame: Game;


  public username:String;

  user:User = new User;
  game:Game = new Game;
  id:String;
  isLogged:Boolean;

  constructor(private gameService:GameService, private route:Router, private authService:AuthService) {}

  ngOnInit(): void {
    this.isLogged = JSON.parse(localStorage.getItem('isLogged')) || false;
    if(!this.isLogged) {this.onLogout();}
    this.username = localStorage.getItem('username');
    this.id = localStorage.getItem('userId');
    //console.log(this.isLogged);
    //console.log(this.username);
    //console.log(this.id);
    this.user.id = +this.id;
    this.user.username = this.username;
    //console.log(this.user);
    this.getGames(this.user);

  }

  public onLogout():void{
    if(localStorage.length >= 1){

      localStorage.clear();
    }

    this.route.navigate(['/']);
  }

  public getGames(user:User): void{
    this.gameService.getGames(user).subscribe(
      (response: Game[]) => {
        this.games = response;
      },
      (error:HttpErrorResponse) => {
        //console.log("Erro: " + error);
      }

    );
  }

  public onAddGame(addForm: NgForm): void {
    document.getElementById('add-game-form').click();
    this.game.name = addForm.controls['name'].value;
    this.game.gameGender = addForm.controls['gameGender'].value;
    this.game.user = this.user;
    //console.log(this.game);
    this.gameService.addGame(this.game).subscribe(
      (response: Game) => {
        //console.log(response);
        // response.user = this.user;
        // this.onUpdateGame(response);
        this.getGames(this.user);
        //console.log('depois de adicioanr jogo ', response)
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        //alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateGame(game: Game): void {
    game.user = this.user;
    this.gameService.updateGame(game).subscribe(
      (response: Game) => {
        this.getGames(this.user);
        //this.getGames(1);
      },
      (error: HttpErrorResponse) => {
        //alert(error.message);
      }
    );
  }

  public onDeleteGame(gameId: number): void {
    this.gameService.deleteGame(gameId).subscribe(
      (response: void) => {
        this.getGames(this.user);
        //this.getGames(1);
      },
      (error: HttpErrorResponse) => {
        //alert(error.message);
      }
    );
  }

  public searchGames(key: string): void {
    //console.log(key);
    const results: Game[] = [];
    for (const game of this.games) {
      if (game.name.toLowerCase().indexOf(key.toLowerCase()) !== -1 && game.name !== null
        || game.gameGender.toLowerCase().indexOf(key.toLowerCase()) !== -1 && game.gameGender !== null) {
          results.push(game);
      }
    }
    this.games = results;
    if (results.length === 0 || !key) {
      this.getGames(this.user);
     //this.getGames(1);
    }
  }


  public onOpenModal(game: Game, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add' ) {
      button.setAttribute('data-target', '#addGameModal');
    }
    if (mode === 'edit' ) {
      this.editGame = game;
      button.setAttribute('data-target', '#updateGameModal');
    }
    if (mode === 'delete' ) {
      this.deleteGame = game;
      button.setAttribute('data-target', '#deleteGameModal');
    }

    container.appendChild(button);
    button.click();

  }
}


