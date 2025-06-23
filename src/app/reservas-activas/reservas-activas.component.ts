import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { AlquilerService } from '../../services/alquiler.service';


@Component({
  selector: 'app-reservas-activas',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './reservas-activas.component.html',
  styleUrls: ['./reservas-activas.component.css'],
  providers: [AlquilerService] // ✅ Asegúrate de inyectar el servicio aquí
})
export class ReservasActivasComponent implements OnInit {

  reservas: any[] = [];
  idUsuario: number = 0;

  constructor(private alquilerService: AlquilerService) {}

  ngOnInit(): void {
    const datosSesion = localStorage.getItem('datosSesion');
    if (datosSesion) {
      const usuario = JSON.parse(datosSesion);
      this.idUsuario = usuario.id;
    }

    this.obtenerReservas(); // 👈 Llama a un método para cargar reservas activas si lo tienes
  }

  cancelarReserva(idReserva: number): void {
    this.alquilerService.cancelarReserva(this.idUsuario, idReserva).subscribe({
      next: (respuesta) => {
        alert(respuesta.mensaje);
        this.reservas = this.reservas.filter(r => r.id_alquiler !== idReserva);
      },
      error: (error) => {
        console.error('❌ Error al cancelar reserva', error);
        alert(error.error.mensaje || 'Error al cancelar reserva.');
      }
    });
  }

  // Este método es opcional si ya lo tienes en el HTML
  obtenerReservas(): void {
    // Aquí iría la llamada para traer las reservas activas del usuario
    // Puedes implementarlo usando this.alquilerService.obtenerReservasActivas(this.idUsuario)
  }
}
