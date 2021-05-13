import { HttpErrorResponse } from '@angular/common/http';
import { User } from './../models/user';

import { AuthService } from './../services/auth.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit {



  form:FormGroup;
  isLogged;
  isFailedLogged;

  constructor(private auth:AuthService, private router:Router) {

   }

  ngOnInit(): void {

    this.isLogged = false;
    this.isFailedLogged = false;
    //localStorage.clear();
    this.initForm();
  }



  initForm(){
    this.form = new FormGroup({
      username: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    })

  }


  doLogin(){
    this.isFailedLogged = false;
    this.isLogged = false;
    if(this.form.valid){
      this.auth.login(this.form.value).subscribe(
        (response:string) =>{
          if(response !== null){
            localStorage.setItem('token', response);
            this.isLogged = true;
            this.auth.getUser(this.form.value).subscribe(
              (response:User) => {
                //this.auth.authenticatedUser = response;
                //this.auth.isLoogedIn = true;
                localStorage.setItem('isLogged', 'true');
                localStorage.setItem('userId', response.id.toString());
                localStorage.setItem('username',response.username.toString())
                this.router.navigate(['/mygames']);
              },
              (response:HttpErrorResponse) => {
                this.isFailedLogged = true;
                //console.log("erro: ", response.message);
              }
            );
          }
        },
        (error:any) => {
          this.isFailedLogged = true;
          //console.log("Erro ao logar (doLogin -- home)");
        }
      );


    }


  }



}
