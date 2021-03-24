import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente2',
  templateUrl: './componente2.component.html',
  styleUrls: ['./componente2.component.css']
})
export class Componente2Component implements OnInit {

  pessoas = [

    {nome: "Fabricio",papel: "professor"},
    {nome: "Cesar",   papel: "aluno"},
    {nome: "Gabriel", papel: "aluno"},
    {nome: "Augusto", papel: "aluno"},
    {nome: "Mariane", papel: "aluno"},
    {nome: "Reiner",  papel: "professor"},
    {nome: "Vitor",   papel: "aluno"},
    {nome: "Wagner",  papel: "aluno"},
    {nome: "Douglas", papel: "aluno"},
    {nome: "Juliano", papel: "aluno"},
    {nome: "Rafael",  papel: "aluno"},
    {nome: "Roberta", papel: "aluno"},
    {nome: "Flavio",  papel: "aluno"}



  ];

  constructor() { }

  ngOnInit(): void {
  }

}
