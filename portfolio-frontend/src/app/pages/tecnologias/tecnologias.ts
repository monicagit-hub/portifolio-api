import { Component, OnInit, signal } from '@angular/core';
import { TecnologiaService, Tecnologia } from '../../services/tecnologia';

@Component({
  selector: 'app-tecnologias',
  imports: [],
  templateUrl: './tecnologias.html',
  styleUrl: './tecnologias.css'
})
export class Tecnologias implements OnInit {

  tecnologias = signal<Tecnologia[]>([]);

  constructor(private tecnologiaService: TecnologiaService) {}

  ngOnInit(): void {
    this.tecnologiaService.listarTodos().subscribe(dados => {
      this.tecnologias.set(dados);
    });
  }
}
