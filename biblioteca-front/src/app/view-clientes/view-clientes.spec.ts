import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewClientes } from './view-clientes';

describe('ViewClientes', () => {
  let component: ViewClientes;
  let fixture: ComponentFixture<ViewClientes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewClientes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewClientes);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
