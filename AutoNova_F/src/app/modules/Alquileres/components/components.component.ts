import { Component, OnInit } from '@angular/core';
import { AlquilerService } from '../services/service.service';
import { Alquiler } from '../entidades/alquiler';

@Component({
  selector: 'app-alquiler',
  templateUrl: './components.component.html',
})
export class AlquilerComponent implements OnInit {
  alquileresPendientes: Alquiler[] = [];

  constructor(private alquilerService: AlquilerService) {}

  ngOnInit(): void {
   this.alquilerService.getAlquileresPendientes().subscribe({
  next: (alquileres: Alquiler[]) => {
    this.alquileresPendientes = alquileres;
  },
  error: (err) => {
    console.error('Error al cargar los alquileres pendientes:', err);
  }
})}};

export class ComponentsComponent {} 
