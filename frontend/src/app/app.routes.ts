import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SeleccionarRolComponent } from './seleccionar-rol/seleccionar-rol.component';
import { BienvenidoComponent } from './bienvenido/bienvenido.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { VerVehiculosComponent } from './ver-vehiculos/ver-vehiculos.component';
import { ReservasActivasComponent } from './reservas-activas/reservas-activas.component';
import { RegistrarGestionComponent } from './registrar-gestion/registrar-gestion.component'; // 👉 Import necesario

export const routes: Routes = [
  { path: '', component: SeleccionarRolComponent },
  { path: 'login/:rol', component: LoginComponent },
  { path: 'bienvenido', component: BienvenidoComponent },
  { path: 'admin/dashboard', component: AdminDashboardComponent },
  { path: 'reservas-activas', component: ReservasActivasComponent },
  { path: 'usuario/ver-vehiculos', component: VerVehiculosComponent },
  { path: 'registrar-gestion', component: RegistrarGestionComponent },
  { path: 'registrar-gestion', component: RegistrarGestionComponent },


  {
    path: 'tabla-gestiones',
    loadComponent: () =>
      import('./tabla-gestiones/tabla-gestiones.component').then(m => m.TablaGestionesComponent)
  },

  { path: '**', redirectTo: '' }
];
