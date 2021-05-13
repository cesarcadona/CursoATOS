import { RegisterComponent } from './register/register.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameControllerComponent } from './game-controller/game-controller.component';

const routes: Routes = [
  {path: 'home', component:HomeComponent},
  {path: 'mygames', component:GameControllerComponent},
  {path: 'register', component:RegisterComponent},
  {path: '', redirectTo:'home', pathMatch:'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
