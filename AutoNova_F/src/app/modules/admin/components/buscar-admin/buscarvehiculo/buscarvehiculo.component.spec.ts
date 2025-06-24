import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarvehiculoComponent } from './buscarvehiculo.component';

describe('BuscarvehiculoComponent', () => {
  let component: BuscarvehiculoComponent;
  let fixture: ComponentFixture<BuscarvehiculoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarvehiculoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BuscarvehiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
