
import { Servico1Service } from './../services/servico1.service';
import { Album } from './../models/Album.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componenteservico1',
  templateUrl: './componenteservico1.component.html',
  styleUrls: ['./componenteservico1.component.css']
})
export class Componenteservico1Component implements OnInit {

  album:Album;
  erro:any;


  constructor(private albumServico:Servico1Service) {

    this.getter();
  }

  getter() {
    this.albumServico.getAlbuns().subscribe(
      (data:Album) => {
        this.album = data;
        console.log('o que retornou em data componente servico 1: ', data);
        console.log('variavel album:', this.album);
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
