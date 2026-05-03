import { Component, OnInit, signal } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ProjetoService, Projeto } from '../../services/projeto';

@Component({
  selector: 'app-projeto-detalhe',
  imports: [RouterLink],
  templateUrl: './projeto-detalhe.html',
  styleUrl: './projeto-detalhe.css'
})
export class ProjetoDetalhe implements OnInit {

  projeto = signal<Projeto | null>(null);

  constructor(
    private route: ActivatedRoute,
    private projetoService: ProjetoService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.projetoService.buscarPorId(id).subscribe(dados => {
      this.projeto.set(dados);
    });
  }
}
