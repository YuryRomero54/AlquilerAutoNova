import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaGestionesComponent } from './tabla-gestiones.component';

describe('TablaGestionesComponent', () => {
  let component: TablaGestionesComponent;
  let fixture: ComponentFixture<TablaGestionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TablaGestionesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TablaGestionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
