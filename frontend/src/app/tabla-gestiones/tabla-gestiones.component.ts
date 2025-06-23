import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GestionesService, Gestion } from '../services/gestion.service';
import { Router } from '@angular/router'; // ✅ IMPORTA Router

@Component({
  selector: 'app-tabla-gestiones',
  standalone: true, // 🔥 obligatorio si usas loadComponent
  imports: [CommonModule],
  templateUrl: './tabla-gestiones.component.html',
  styleUrls: ['./tabla-gestiones.component.css']
})
export class TablaGestionesComponent implements OnInit {
  gestiones: Gestion[] = [];
  error = '';

  constructor(
    private gestionesService: GestionesService,
    private router: Router // ✅ INYECTA Router AQUÍ
  ) {}

  ngOnInit(): void {
    this.gestionesService.obtenerTodasLasGestiones().subscribe({
      next: (data) => {
        this.gestiones = data;
      },
      error: (err) => {
        this.error = '❌ Error al cargar gestiones.';
        console.error(err);
      }
    });
  }

  volver() {
    this.router.navigate(['/registrar-gestion']); // ✅ Redirige a la ruta deseada
  }
}
