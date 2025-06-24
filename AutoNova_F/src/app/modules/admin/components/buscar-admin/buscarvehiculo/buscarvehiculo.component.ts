import { Component } from '@angular/core';
import { ServiceService } from '../../../../Vehiculos/services/vehiculo.service';
import { Vehiculo } from '../../../../Vehiculos/entidades/vehiculo';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AlquilerService } from '../../../../Alquileres/services/service.service';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzDescriptionsModule } from 'ng-zorro-antd/descriptions';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-buscarvehiculo',
  standalone: true,
  imports: [NzCardModule,NzFormModule,NzInputModule,NzIconModule,NzButtonModule,NzDescriptionsModule,
    CommonModule,ReactiveFormsModule
  ],
  templateUrl: './buscarvehiculo.component.html',
  styleUrl: './buscarvehiculo.component.css'
})
export class BuscarvehiculoComponent {
FormBuscar:FormGroup;
  vehiculo: Vehiculo | null = null;
 mensaje: string = '';

  constructor(private vehiculoService:ServiceService, private fb:FormBuilder,private alquilerService:AlquilerService ){
    this.FormBuscar=this.fb.group({
      idAlquiler: ['']

    });

  

  }
  BuscarVehiculoPorIdAlquiler(){
    const idAlquiler= this.FormBuscar.value.idAlquiler;

    if (!idAlquiler) {
      this.mensaje = 'Por favor ingresa un ID de alquiler válido.';
      this.vehiculo = null;
      return;
    }
      this.alquilerService.buscarVehiculoPorIdAlquiler(idAlquiler).subscribe({
      next: (data) => {
        this.vehiculo = data;
        this.mensaje = '';
      },
      error: (err) => {
        this.vehiculo = null;
        this.mensaje = 'Vehículo no encontrado para ese número de alquiler.';
      }
    });
  }


    CambiarEstadoADisponible() {
    if (this.vehiculo) {
      this.vehiculoService.cambiarEstadoAVehiculoDisponible(this.vehiculo.idVehiculo).subscribe({
        next: () => {
          this.mensaje = 'Estado actualizado a "disponible".';
        },
        error: () => {
          this.mensaje = 'Error al actualizar el estado del vehículo.';
        }
      });
    } else {
      this.mensaje = 'Primero busca un vehículo.';
    }
  }

}


