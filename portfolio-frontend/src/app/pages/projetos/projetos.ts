import { Component, OnInit, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ProjetoService, Projeto } from '../../services/projeto';

@Component({
  selector: 'app-projetos',
  imports: [RouterLink],
  templateUrl: './projetos.html',
  styleUrl: './projetos.css'
})
export class Projetos implements OnInit {

  projetos = signal<Projeto[]>([]);

  constructor(private projetoService: ProjetoService) {}

  ngOnInit(): void {
    this.projetoService.listarTodos().subscribe(dados => {
      this.projetos.set(dados);
    });
  }
}
