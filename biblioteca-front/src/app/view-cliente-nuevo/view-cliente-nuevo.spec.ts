import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewClienteNuevo } from './view-cliente-nuevo';

describe('ViewClienteNuevo', () => {
  let component: ViewClienteNuevo;
  let fixture: ComponentFixture<ViewClienteNuevo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewClienteNuevo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewClienteNuevo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
