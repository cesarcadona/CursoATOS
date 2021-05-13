import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { HttpErrorResponse, HttpResponse, HttpResponseBase } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  isRegister;
  isFailedRegister;


  form:FormGroup;

  constructor(private route:Router, private auth:AuthService) { }

  ngOnInit(): void {
    this.isFailedRegister = false;
    this.isRegister = false;
    this.initForm();
  }

  initForm(){
    this.form = new FormGroup({
      username: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required]),
    })
  }
  doRegister(){
    this.isFailedRegister = false;
    this.isRegister = false;
    if(this.form.valid){
      this.auth.register(this.form.value).subscribe(
        (response:Boolean) => {
          this.isRegister = true;
          this.route.navigate(['/']);
          //console.log("register " + response);
        },
        (response:HttpErrorResponse) =>{
          this.isFailedRegister = true;
          //console.log("erro: " + response.message);
        }

      )
    }

  }

}
