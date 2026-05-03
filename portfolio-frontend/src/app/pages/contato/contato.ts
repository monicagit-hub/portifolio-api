import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contato',
  imports: [FormsModule],
  templateUrl: './contato.html',
  styleUrl: './contato.css'
})
export class Contato {

  nome: string = '';
  email: string = '';
  mensagem: string = '';
  enviado = signal(false);

  enviar() {
    if (this.nome && this.email && this.mensagem) {
      console.log('Mensagem enviada:', { nome: this.nome, email: this.email, mensagem: this.mensagem });
      this.enviado.set(true);
      this.nome = '';
      this.email = '';
      this.mensagem = '';
    }
  }
}
