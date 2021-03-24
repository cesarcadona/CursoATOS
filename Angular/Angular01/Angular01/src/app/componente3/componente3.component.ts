import { Pessoa } from './../models/Pessoa.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente3',
  templateUrl: './componente3.component.html',
  styleUrls: ['./componente3.component.css']
})
export class Componente3Component implements OnInit {

  pessoas = [

    new Pessoa("Fabricio","professor"),
    new Pessoa( "Cesar", "aluno"),
    new Pessoa( "Gabriel", "aluno"),
    new Pessoa( "Augusto", "aluno"),
    new Pessoa( "Mariane", "aluno"),
    new Pessoa( "Reiner", "profesor"),
    new Pessoa( "Vitor", "aluno"),
    new Pessoa( "Wagner", "aluno"),
    new Pessoa( "Douglas", "aluno"),
    new Pessoa( "Juliano", "aluno"),
    new Pessoa( "Rafael", "aluno"),
    new Pessoa( "Roberta", "aluno"),
    new Pessoa( "Flavio",  "aluno")


  ];
  constructor() { }

  ngOnInit(): void {
  }

}
