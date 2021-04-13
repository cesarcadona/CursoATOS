import { ServicoService } from './../services/servico.service';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente-servico',
  templateUrl: './componente-servico.component.html',
  styleUrls: ['./componente-servico.component.css']
})
export class ComponenteServicoComponent implements OnInit {

  erro:any;


  constructor(private servicoService:ServicoService) {

   }



  ngOnInit(): void {
  }

}
