import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bienvenido',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './bienvenido.component.html',
  styleUrls: ['./bienvenido.component.css']
})
export class BienvenidoComponent implements OnInit {
  sesion: any = null;

  ngOnInit(): void {
    const datos = localStorage.getItem('datosSesion');
    this.sesion = datos ? JSON.parse(datos) : null;
  }

  cerrarSesion() {
    localStorage.removeItem('datosSesion');
    window.open('/', '_self');
  }

  irAlDashboard() {
    window.open('/admin/dashboard', '_self');
  }

 verInformacion() {
  window.open('/usuario/ver-vehiculos', '_self');

  }
}

