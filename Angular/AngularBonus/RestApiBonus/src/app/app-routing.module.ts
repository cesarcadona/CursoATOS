import { Componente1Component } from './componente1/componente1.component';
import { ComponenteServicoComponent } from './componente-servico/componente-servico.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'componente', component:ComponenteServicoComponent},
  {path:'componente1', component:Componente1Component}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
