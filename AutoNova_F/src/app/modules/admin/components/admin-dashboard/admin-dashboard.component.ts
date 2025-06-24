import { Component, OnInit } from '@angular/core';
import { AlquilerService } from '../../../Alquileres/services/service.service'
import { Alquiler } from '../../../Alquileres/entidades/alquiler';
import { NgFor } from '@angular/common';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzTagModule } from 'ng-zorro-antd/tag';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { CommonModule } from '@angular/common';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { RouterOutlet } from '@angular/router';
import { RouterLink } from '@angular/router';
import { AdminLayoutComponent } from '../admin-layout/admin-layout.component';
 



@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  standalone:true,
  imports:[NgFor, NzIconModule,NzTableModule,NzTagModule,CommonModule
    ,   NzCardModule, NzLayoutModule, RouterOutlet,RouterOutlet,RouterLink,
    AdminLayoutComponent
  ]
})
export class AdminDashboardComponent implements OnInit {
  alquileresPendientes: Alquiler[] = [];

  constructor(private alquilerService: AlquilerService) {}

  ngOnInit(): void {
    this.alquilerService.getAlquileresPendientes().subscribe((data) => {
      this.alquileresPendientes = data;
    });
 

  }
  
}
