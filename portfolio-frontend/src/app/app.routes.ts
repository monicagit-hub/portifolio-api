import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Projetos } from './pages/projetos/projetos';
import { ProjetoDetalhe } from './pages/projeto-detalhe/projeto-detalhe';
import { Tecnologias } from './pages/tecnologias/tecnologias';
import { Contato } from './pages/contato/contato';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'projetos', component: Projetos },
  { path: 'projetos/:id', component: ProjetoDetalhe },
  { path: 'tecnologias', component: Tecnologias },
  { path: 'contato', component: Contato },
  { path: '**', redirectTo: '' }
];
