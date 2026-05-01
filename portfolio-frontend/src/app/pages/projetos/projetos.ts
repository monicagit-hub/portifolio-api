import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ProjetoService, Projeto } from '../../services/projeto';

@Component({
  selector: 'app-projetos',
  imports: [CommonModule, RouterLink],
  templateUrl: './projetos.html',
  styleUrl: './projetos.css'
})
export class Projetos implements OnInit {

  projetos: Projeto[] = [];

   constructor(private projetoService: ProjetoService) {}

  ngOnInit(): void {
    this.projetoService.listarTodos().subscribe(dados => {
      this.projetos = dados;
    });
  }
}
