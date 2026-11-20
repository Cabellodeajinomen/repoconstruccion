import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { ServiceAdministrarClientes } from '../services/service-administrar-clientes';

@Component({
  selector: 'app-view-cliente-nuevo',
  imports: [FormsModule, RouterLink],
  templateUrl: './view-cliente-nuevo.html',
  styleUrl: './view-cliente-nuevo.css',
})
export class ViewClienteNuevo {

  private service = inject(ServiceAdministrarClientes);
  private router = inject(Router);

  // Los mismos IDs que están en tu data.sql (tabla tipo_cliente)
  tiposCliente = [
    { id: 1001, nombre: 'Estudiante' },
    { id: 1002, nombre: 'Docente' },
    { id: 1003, nombre: 'Administrativo' },
    { id: 1004, nombre: 'Externo' }
  ];

  // Mismo formato que RequestCliente.java
  cliente = {
    nombreCompleto: '',
    dni: '',
    email: '',
    idTipoCliente: 1001
  };

  mensajeError = '';

  guardar(): void {
    console.log('Cliente a guardar:', this.cliente);
    this.service.registrarCliente(this.cliente).subscribe({
      next: (data) => {
        console.log('Cliente registrado:', data);
        this.router.navigate(['/clientes']);
      },
      error: (err) => {
        console.error('Error al registrar:', err);
        this.mensajeError = err.status === 409
          ? 'Ya existe un cliente con ese DNI.'
          : 'No se pudo registrar el cliente.';
      },
    });
  }

  limpiar(): void {
    this.cliente = { nombreCompleto: '', dni: '', email: '', idTipoCliente: 1001 };
    this.mensajeError = '';
  }
}