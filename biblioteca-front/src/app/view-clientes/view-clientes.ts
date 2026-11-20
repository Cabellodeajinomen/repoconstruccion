import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceAdministrarClientes } from '../services/service-administrar-clientes';

@Component({
  selector: 'app-view-clientes',
  imports: [],
  templateUrl: './view-clientes.html',
  styleUrl: './view-clientes.css',
})
export class ViewClientes {

  private router = inject(Router);

  clientes!: any[];

  private serviceAdministrarClientes = inject(ServiceAdministrarClientes);

  constructor(private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.serviceAdministrarClientes.getClientes().subscribe({
      next: (data) => {
        console.log('Datos recibidos del servicio:', data);
        this.clientes = data;
        this.cdr.markForCheck();
      },
      error: (err) => console.error('Error al llamar al servicio:', err),
    });
  }

  irAClienteNuevo() {
    this.router.navigate(['/cliente/nuevo']);
  }
}