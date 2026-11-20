import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ServiceAdministrarClientes {

  private http = inject(HttpClient);
  private urlClientes = `${environment.apiUrl}/clientes`;
  private urlClienteNuevo = `${environment.apiUrl}/cliente/nuevo`;

  // GET → lista de clientes
  getClientes(): Observable<any[]> {
    return this.http.get<any[]>(this.urlClientes);
  }

  // POST → registra un cliente nuevo
  registrarCliente(c: any): Observable<any> {
    return this.http.post<any>(this.urlClienteNuevo, c);
  }
}