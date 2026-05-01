import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// interface que representa uma tecnologia
export interface Tecnologia {
  id?: number;
  nome: string;
  iconeUrl?: string;
}

@Injectable({
  providedIn: 'root'
})
export class TecnologiaService {

  private apiUrl = 'http://localhost:8080/tecnologias';

  constructor(private http: HttpClient) {}

  listarTodos(): Observable<Tecnologia[]> {
    return this.http.get<Tecnologia[]>(this.apiUrl);
  }

  buscarPorId(id: number): Observable<Tecnologia> {
    return this.http.get<Tecnologia>(`${this.apiUrl}/${id}`);
  }

  salvar(tecnologia: Tecnologia): Observable<Tecnologia> {
    return this.http.post<Tecnologia>(this.apiUrl, tecnologia);
  }

  atualizar(id: number, tecnologia: Tecnologia): Observable<Tecnologia> {
    return this.http.put<Tecnologia>(`${this.apiUrl}/${id}`, tecnologia);
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
