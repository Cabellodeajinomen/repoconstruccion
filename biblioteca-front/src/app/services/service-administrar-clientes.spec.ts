import { TestBed } from '@angular/core/testing';

import { ServiceAdministrarClientes } from './service-administrar-clientes';

describe('ServiceAdministrarClientes', () => {
  let service: ServiceAdministrarClientes;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceAdministrarClientes);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
