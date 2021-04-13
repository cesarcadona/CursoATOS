import { Component, OnInit } from '@angular/core';
import { ServicoService } from '../services/servico.service';


@Component({
  selector: 'app-componente1',
  templateUrl: './componente1.component.html',
  styleUrls: ['./componente1.component.css']
})
export class Componente1Component implements OnInit {

  timeModel:ArrayBuffer;

  erro:any;


  constructor(private servicoService:ServicoService) {
    this.getter();
   }


  getter(){
    this.servicoService.getTimeNow().subscribe(
      (data:ArrayBuffer) =>{
        this.timeModel = data;
        console.log('o que retornou em data componente servico: ', data);
        console.log('variavel timeModel: ', this.timeModel);
      },
      (error:any) => {
        this.erro = error;
        console.error('Erro: ', this.erro);
      }
    );
   }

  ngOnInit(): void {

  }

}
