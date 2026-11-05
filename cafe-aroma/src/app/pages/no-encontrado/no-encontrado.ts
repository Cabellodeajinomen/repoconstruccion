import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';   // ← 1

@Component({
  selector: 'app-no-encontrado',
  imports: [RouterLink],                         // ← 2
  templateUrl: './no-encontrado.html',
  styleUrl: './no-encontrado.css'
})
export class NoEncontrado {}