import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarGestionComponent } from './registrar-gestion.component';

describe('RegistrarGestionComponent', () => {
  let component: RegistrarGestionComponent;
  let fixture: ComponentFixture<RegistrarGestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarGestionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegistrarGestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
