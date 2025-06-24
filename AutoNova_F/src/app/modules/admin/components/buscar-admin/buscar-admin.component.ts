import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { CommonModule } from '@angular/common';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzDescriptionsModule } from 'ng-zorro-antd/descriptions';
import { AlquilerService } from '../../../Alquileres/services/service.service';
import { ServiceService } from '../../../Vehiculos/services/vehiculo.service';
import { Alquiler } from '../../../Alquileres/entidades/alquiler';
import { Vehiculo } from '../../../Vehiculos/entidades/vehiculo';


@Component({
  selector: 'app-buscar-admin',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    NzInputModule,
    NzIconModule,
    NzButtonModule,
    NzCardModule,
        NzDescriptionsModule
  ],
  templateUrl: './buscar-admin.component.html',
  styleUrl: './buscar-admin.component.css'
})
export class BuscarAdminComponent {
  formBusqueda: FormGroup;
alquilerEncontrado: Alquiler | null = null;
  vehiculo: Vehiculo | null = null;


  constructor(private fb: FormBuilder, private alquilerservice:AlquilerService,private vehiculoservice:ServiceService,private message: NzMessageService
  ) {
    this.formBusqueda = this.fb.group({
      placa: ['']
    });
}

buscarVehiculoPorPlaca() {
    const placa = this.formBusqueda.value.placa;
    this.alquilerservice.obtenerAlquilerPorPlaca(placa).subscribe({
  next: data => {
    this.alquilerEncontrado = data;
  },
  error: err => {
    this.alquilerEncontrado = null;
    console.error('No encontrado', err);
  },
  complete: () => {
    console.log('Búsqueda completada');
  }
});
  }
entregarVehiculo() {
  if (!this.alquilerEncontrado) {
    console.error('No hay alquiler cargado');
    return;
  }

  const id = this.alquilerEncontrado.idAlquiler;
  this.alquilerservice.actualizarEstado(id, 'entregado').subscribe({
    next: () => {
      this.alquilerEncontrado!.estado = 'entregado';
       this.message.success('Vehículo marcado como entregado');
    },
    error: err => {
      console.error('Error al actualizar estado', err);
    }
  });
}}
