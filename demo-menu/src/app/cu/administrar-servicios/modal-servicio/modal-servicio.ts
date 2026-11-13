import { Component, input, output } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-modal-servicio',
  imports: [FormsModule],
  templateUrl: './modal-servicio.html',
  styleUrl: './modal-servicio.css',
})
export class ModalServicio {

  servicio = input<any>();

  cerrar = output<void>();
  guardar = output<any>();

  onGuardar(form: NgForm) {
    if (form.invalid) return;
    this.guardar.emit(this.servicio());
  }
}