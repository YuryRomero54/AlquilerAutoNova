import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-seleccionar-rol',
  standalone: true,
  templateUrl: './seleccionar-rol.component.html',
  styleUrls: ['./seleccionar-rol.component.css'],
  imports: [CommonModule, RouterModule]
})
export class SeleccionarRolComponent {
  constructor(private router: Router) {}

  irALogin(rol: string) {
    this.router.navigate(['/login', rol]);
  }
}
