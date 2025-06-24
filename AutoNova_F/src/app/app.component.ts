import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { AdminDashboardComponent } from './modules/admin/components/admin-dashboard/admin-dashboard.component';
import { ComponentsComponent } from './modules/Vehiculos/components/components.component';
import { BuscarAdminComponent } from './modules/admin/components/buscar-admin/buscar-admin.component';
import { BuscarvehiculoComponent } from './modules/admin/components/buscar-admin/buscarvehiculo/buscarvehiculo.component';
// NG ZORRO imports
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
     RouterModule, 
    NzLayoutModule,
    NzSpinModule,
    NzFormModule,
    NzButtonModule,
    NzInputModule,
    AdminDashboardComponent,
    ComponentsComponent,
    BuscarAdminComponent ,
    BuscarvehiculoComponent
    
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'car_rental_angular';
}


