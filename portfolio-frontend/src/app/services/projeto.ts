import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Tecnologia} from './tecnologia';
import { environment } from '../../environments/environment';

export interface Projeto {
  id?: number;
  nome: string;
  descricao: string;
  imagemUrl?: string;
  linkDemo?: string;
  linkGithub: string;
  documentacao?: string;
}

@Injectable({
  providedIn: 'root'
})
export class ProjetoService {

  private apiUrl =`${environment.apiUrl}/projetos`;

  constructor(private http: HttpClient) {}

  listarTodos(): Observable<Projeto[]> {
    return this.http.get<Projeto[]>(this.apiUrl);
  }

  buscarPorId(id: number): Observable<Projeto> {
    return this.http.get<Projeto>(`${this.apiUrl}/${id}`);
  }

  salvar(tecnologia: Tecnologia): Observable<Tecnologia> {
    return this.http.post<Tecnologia>(this.apiUrl, tecnologia);
  }

  atualizar(id: number, projeto: Projeto): Observable<Projeto> {
    return this.http.put<Projeto>(`${this.apiUrl}/${id}`, projeto);
  }

   deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
