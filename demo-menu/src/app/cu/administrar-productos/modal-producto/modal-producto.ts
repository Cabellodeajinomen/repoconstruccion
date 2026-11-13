import { Component, input, output } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-modal-producto',
  imports: [FormsModule],
  templateUrl: './modal-producto.html',
  styleUrl: './modal-producto.css',
})
export class ModalProducto {

  producto = input<any>();

  cerrar = output<void>();
  guardar = output<any>();

  onGuardar(form: NgForm) {
    if (form.invalid) return;
    this.guardar.emit(this.producto());
  }
}