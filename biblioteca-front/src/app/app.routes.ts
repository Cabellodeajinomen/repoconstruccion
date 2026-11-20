import { Routes } from '@angular/router';
import { ViewClientes } from './view-clientes/view-clientes';
import { ViewClienteNuevo } from './view-cliente-nuevo/view-cliente-nuevo';

export const routes: Routes = [
  { path: '', redirectTo: 'clientes', pathMatch: 'full' },
  { path: 'clientes', component: ViewClientes, title: 'Listado de clientes' },
  { path: 'cliente/nuevo', component: ViewClienteNuevo, title: 'Cliente nuevo' }
];