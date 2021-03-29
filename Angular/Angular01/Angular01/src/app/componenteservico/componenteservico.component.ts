import { ActivatedRoute } from '@angular/router';
import { Servico1Service } from './../services/servico1.service';
import { Photo } from './../models/Photo.model';
import { Component,  OnInit } from '@angular/core';


@Component({
  selector: 'app-componenteservico',
  templateUrl: './componenteservico.component.html',
  styleUrls: ['./componenteservico.component.css']
})
export class ComponenteservicoComponent implements OnInit {

  photos:Photo;
  erro:any;
  albumId:number;


  constructor(private photoServico:Servico1Service, private route:ActivatedRoute) {

    this.getter();
  }

  getter() {

    this.photoServico.getPhotos().subscribe(
      (data:Photo) => {
          this.photos = data;
          console.log('o que retornou em data componemte servico: ' , data);
          console.log('variavel photos: ', this.photos);
      },
      (error:any) => {
        this.erro = error;

        console.error('Erro: ', this.erro);
      }

    );

  }


  ngOnInit(): void {

    this.route.queryParams
      .subscribe(params => {

        this.albumId = params.albumId;
        console.log(params);

      }
    );

  }

}
