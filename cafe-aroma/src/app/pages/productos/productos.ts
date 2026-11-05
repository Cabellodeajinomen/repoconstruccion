import { Component } from '@angular/core';

@Component({
  selector: 'app-productos',
  imports: [],
  templateUrl: './productos.html',
  styleUrl: './productos.css'
})
export class Productos {
  // Lista de productos (datos de ejemplo)
  productos = [
    { id: 1, nombre: 'Café Americano', categoria: 'Bebida caliente', precio: 8.00, stock: 50 },
    { id: 2, nombre: 'Capuccino', categoria: 'Bebida caliente', precio: 10.50, stock: 30 },
    { id: 3, nombre: 'Frappé de Moka', categoria: 'Bebida fría', precio: 14.00, stock: 20 },
    { id: 4, nombre: 'Cheesecake de maracuyá', categoria: 'Postre', precio: 12.00, stock: 0 },
    { id: 5, nombre: 'Café en grano 250g', categoria: 'Para llevar', precio: 35.00, stock: 15 },
    { id: 6, nombre: 'Empanada de pollo', categoria: 'Salado', precio: 7.50, stock: 25 }
  ];
}