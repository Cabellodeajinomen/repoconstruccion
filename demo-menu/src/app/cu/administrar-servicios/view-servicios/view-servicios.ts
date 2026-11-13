import { Component } from '@angular/core';
import { ModalServicio } from '../modal-servicio/modal-servicio';

@Component({
  selector: 'app-view-servicios',
  imports: [ModalServicio],
  templateUrl: './view-servicios.html',
  styleUrl: './view-servicios.css',
})
export class ViewServicios {

  servicios: any[] = [
    { id: 1, nombre: 'Mantenimiento de PC', categoria: 'Soporte', duracion: '2 horas', precio: 80 },
    { id: 2, nombre: 'Instalación de software', categoria: 'Software', duracion: '1 hora', precio: 40 },
    { id: 3, nombre: 'Reparación de laptops', categoria: 'Hardware', duracion: '1 día', precio: 150 },
    { id: 4, nombre: 'Configuración de redes', categoria: 'Redes', duracion: '3 horas', precio: 120 }
  ];

  mostrarModal = false;
  servicioSeleccionado: any = null;

  editarServicio(servicio: any) {
    this.servicioSeleccionado = { ...servicio };
    this.mostrarModal = true;
  }

 guardarServicio(servicioEditado: any) {
  this.servicios = this.servicios.map(s =>
    s.id === servicioEditado.id ? { ...servicioEditado } : s
  );

  console.log('Servicio guardado:', servicioEditado);
  console.log('Lista actualizada:', this.servicios);

  this.cerrarModal();
}

  cerrarModal() {
    this.mostrarModal = false;
    this.servicioSeleccionado = null;
  }
}