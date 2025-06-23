import { Component, Inject, OnInit, PLATFORM_ID } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReservasService } from '../services/reservas.service';

@Component({
  selector: 'app-reservas-activas',
  standalone: true,
  templateUrl: './reservas-activas.component.html',
  styleUrls: ['./reservas-activas.component.css'],
  imports: [CommonModule, FormsModule]
})
export class ReservasActivasComponent implements OnInit {
  idUsuario = 0;
  idAlquiler = 0;
  mensaje = '';
  mostrarFormulario = false;

  constructor(
    private reservasService: ReservasService,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      try {
        const datos = JSON.parse(localStorage.getItem('datosSesion') || '{}');
        this.idUsuario = datos?.idUsuario || datos?.id || 0;

        if (!this.idUsuario) {
          this.mensaje = '⚠️ No se encontró el ID del usuario.';
        }
      } catch (error) {
        console.error('Error al leer localStorage:', error);
        this.mensaje = '⚠️ Error al leer el ID del usuario.';
      }
    } else {
    }
  }

  cancelarReserva(): void {
    if (!this.idUsuario || !this.idAlquiler) {
      console.log('🟡 Faltan datos, no se envía petición:', {
        idUsuario: this.idUsuario,
        idAlquiler: this.idAlquiler
      });

      this.mensaje = '❗ Por favor ingresa ambos IDs.';
      return;
    }

    console.log('🟡 Enviando datos:', {
      idUsuario: this.idUsuario,
      idAlquiler: this.idAlquiler
    });

    this.reservasService.cancelarReserva(this.idUsuario, this.idAlquiler).subscribe({
      next: (res) => {
        this.mensaje = res.mensaje || '✅ Reserva cancelada correctamente.';
      },
      error: (err) => {
        console.error('❌ Error al cancelar reserva:', err);
        console.log('⛔ Detalle del error del backend:', err.error);

        if (err.error && typeof err.error === 'object' && err.error.mensaje) {
          this.mensaje = err.error.mensaje;
        } else if (typeof err.error === 'string') {
          this.mensaje = `❌ ${err.error}`;
        } else {
          this.mensaje = '❌ Error inesperado.';
        }
      }
    });
  }
}
