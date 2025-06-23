import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { GestionesService, Gestion } from '../services/gestion.service';

@Component({
  selector: 'app-registrar-gestion',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './registrar-gestion.component.html',
  styleUrls: ['./registrar-gestion.component.css']
})
export class RegistrarGestionComponent {
  gestion = {
    idAdmin: 0,
    idAlquiler: 0,
    observaciones: ''
  };

  registroExitoso: boolean = false;
  errorMensaje: string = '';
  mostrarTabla: boolean = false;
  gestionesRegistradas: Gestion[] = [];

  constructor(private gestionesService: GestionesService) {}

 registrar() {
  const { idAdmin, idAlquiler, observaciones } = this.gestion;

  if (!idAdmin || !idAlquiler || !observaciones.trim()) {
    this.errorMensaje = '❗ Todos los campos son obligatorios.';
    this.registroExitoso = false;
    return;
  }

  const body = {
    idAdmin,
    idAlquiler,
    observaciones: observaciones // ✅ Sin fecha ni hora
  };

  this.gestionesService.registrarGestion(body).subscribe({
    next: (res) => {
      this.registroExitoso = true;
      this.errorMensaje = '';
      this.mostrarTabla = false;
      setTimeout(() => this.registroExitoso = false, 3000);
    },
    error: (err) => {
      this.errorMensaje = '❌ Error al registrar la gestión.';
      this.registroExitoso = false;
    }
  });
}


  abrirTablaGestiones(event: Event): void {
  event.preventDefault();
  window.open('/tabla-gestiones', '_blank');
}


  verGestiones() {
    const idAlquiler = this.gestion.idAlquiler;
    if (!idAlquiler) {
      this.errorMensaje = '❗ Por favor ingresa el ID del alquiler para ver gestiones.';
      return;
    }

    this.errorMensaje = '';
    this.gestionesService.obtenerGestionesPorAlquiler(idAlquiler).subscribe({
      next: (data) => {
        this.gestionesRegistradas = data;
        this.mostrarTabla = true;
      },
      error: (err) => {
        this.errorMensaje = '❌ Error al obtener las gestiones.';
      }
    });
  }
}
