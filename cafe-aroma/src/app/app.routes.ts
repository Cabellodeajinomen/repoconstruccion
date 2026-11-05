import { Routes } from '@angular/router';
import { Inicio } from './pages/inicio/inicio';
import { Productos } from './pages/productos/productos';
import { NoEncontrado } from './pages/no-encontrado/no-encontrado';

export const routes: Routes = [
  { path: '', component: Inicio },            // raíz: localhost:4200/
  { path: 'productos', component: Productos }, // localhost:4200/productos
  { path: '**', component: NoEncontrado }      // cualquier otra ruta → 404
];