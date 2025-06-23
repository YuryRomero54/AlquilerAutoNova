import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, ActivatedRoute, Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, HttpClientModule],
  providers: [LoginService],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  correo: string = '';
  contrasena: string = '';
  datosSesion: any;
  rolSeleccionado: string = '';
  mensajeError: string = '';

  constructor(
    private loginService: LoginService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.rolSeleccionado = this.route.snapshot.paramMap.get('rol') ?? '';
  }

  iniciarSesion(): void {
    const datos = {
      correoUsuario: this.correo,
      password: this.contrasena
    };

    this.loginService.login(datos).subscribe({
      next: (respuesta: any) => {
        const rolReal = respuesta.usuario.rol;
        const rolEsperado = this.rolSeleccionado;
        
        if (rolReal.toLowerCase() !== rolEsperado.toLowerCase()) {
          this.mensajeError = ` No puedes ingresar como ${rolEsperado}. Tu rol real es: ${rolReal}`;
          return;
        }

        this.datosSesion = {
          nombre: respuesta.usuario.nombre,
          rol: rolReal,
          correo: respuesta.usuario.correo,
          horaInicio: respuesta.horaInicioSesion
        };

        localStorage.setItem('datosSesion', JSON.stringify(this.datosSesion));

   if (rolReal === 'Administrador') {
  this.router.navigate(['/bienvenido']);
}

 else if (rolReal === 'Usuario') {
          this.router.navigate(['/usuario/ver-vehiculos']);
        } else {
          this.router.navigate(['/bienvenido']);
        }
      },
      error: () => {
        this.mensajeError = "❌ Error al iniciar sesión. Revisa tus credenciales.";
      }
    });
  }
}

