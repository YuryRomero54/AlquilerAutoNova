import { Injectable } from '@angular/core';
import { Vehiculo } from '../entidades/vehiculo';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL="http://localhost:8085/vehiculos";
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { 

  
  }
   getVehiculosDisponibles(tipo: string, estado: string): Observable<Vehiculo[]> {
    const url = `${BASE_URL}/verdisponibles?tipo=${tipo}&estado=${estado}`;
    return this.http.get<Vehiculo[]>(url);
  }

buscarporplaca(placa: string): Observable<Vehiculo> {  
  return this.http.get<Vehiculo>(`${BASE_URL}/buscarporplaca?placa=${placa}`);
}
 cambiarEstadoAVehiculoDisponible(idVehiculo: number): Observable<any> {
  return this.http.put(
    `${BASE_URL}/actualizarEstado?idVehiculo=${idVehiculo}&estado=disponible`,
    {}
  );
}
}
