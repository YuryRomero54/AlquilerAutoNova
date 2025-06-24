import { Routes } from '@angular/router';
import { SignupComponent } from './auth/components/signup/signup.component';
import { LoginComponent } from './auth/components/login/login.component';
import { AdminDashboardComponent } from './modules/admin/components/admin-dashboard/admin-dashboard.component';
import { ComponentsComponent } from './modules/Vehiculos/components/components.component';
import { AdminLayoutComponent } from './modules/admin/components/admin-layout/admin-layout.component';
import { BuscarAdminComponent } from './modules/admin/components/buscar-admin/buscar-admin.component';
import { BuscarvehiculoComponent } from './modules/admin/components/buscar-admin/buscarvehiculo/buscarvehiculo.component';


export const routes: Routes = [
    {path:"register",component: SignupComponent},
     {path:"login",component: LoginComponent},

  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      { path: 'dashboard', component: AdminDashboardComponent },
      { path: 'vehiculos', component: ComponentsComponent },
       { path: 'update', component: BuscarAdminComponent },
       { path: 'updateVehiculo', component: BuscarvehiculoComponent },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
    ]
  },

];
     

