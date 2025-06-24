import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { HttpClientModule } from '@angular/common/http';
import { ServiceService } from '../services/vehiculo.service';
import { Vehiculo } from '../entidades/vehiculo';
import { NgFor } from '@angular/common';
import { NgIf } from '@angular/common';
import { NzListModule } from 'ng-zorro-antd/list';
import { CommonModule } from '@angular/common';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzEmptyModule } from 'ng-zorro-antd/empty';
import { NzIconModule } from 'ng-zorro-antd/icon';



@Component({
  selector: 'app-components',
  standalone: true,
  imports: [FormsModule,NzSelectModule,NgFor,NgIf,HttpClientModule,NzListModule,CommonModule,NzCardModule,NzEmptyModule,
    NzIconModule
  ],
  templateUrl: './components.component.html',
  styleUrl: './components.component.css'
})
export class ComponentsComponent implements OnInit {

    tiposDeVehiculos: string[] = ['motocicleta', 'camioneta', 'automovil', 'campero', 'microbus'];
    tipoSeleccionado: string = '' ;
    vehiculosFiltrados: Vehiculo[] = [];
   ngOnInit(): void {

    }
  
constructor(private vehiculoservice : ServiceService){}

    filtrarVehiculosPorTipo(){
      this.vehiculoservice.getVehiculosDisponibles(this.tipoSeleccionado,"pendiente").subscribe((vehiculos)=>
      {
        console.log('Vehiculos:',vehiculos)
        this.vehiculosFiltrados=vehiculos;

      })



    }
}
