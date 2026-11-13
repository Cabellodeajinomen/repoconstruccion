import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewServicios } from './view-servicios';

describe('ViewServicios', () => {
  let component: ViewServicios;
  let fixture: ComponentFixture<ViewServicios>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewServicios]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewServicios);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
