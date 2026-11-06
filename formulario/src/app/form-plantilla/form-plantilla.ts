import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

// Estructura de datos de registro
interface Registro {
  nombre: string;
  apellido: string;
  email: string;
  edad: number;
  telefono: string;
  comentario: string;
  genero: string;
  carrera: string;
}

@Component({
  selector: 'app-form-plantilla',
  imports: [CommonModule, FormsModule],
  templateUrl: './form-plantilla.html',
  styleUrl: './form-plantilla.css',
})
export class FormPlantilla {

  // Aquí se almacenan los datos que se muestran en la tabla
  registros: Registro[] = [];

  onSubmit(form: NgForm) {
    console.log('Data del formulario:', form.value);

    // Copiamos los valores del formulario y los agregamos al arreglo
    const obj: Registro = { ...form.value };
    this.registros.push(obj);

    // Limpia el formulario y su estado (touched, dirty, etc.)
    form.resetForm();
  }

  eliminar(index: number) {
    this.registros.splice(index, 1);
  }
}