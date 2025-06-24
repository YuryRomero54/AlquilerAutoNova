
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Alquiler } from '../entidades/alquiler'; 
import { Vehiculo } from '../../Vehiculos/entidades/vehiculo';

@Injectable({
  providedIn: 'root',
})
export class AlquilerService {
  private baseUrl = 'http://localhost:8085/alquileres';

  constructor(private http: HttpClient) {}

  getAlquileresPendientes(): Observable<Alquiler[]> {
    return this.http.get<Alquiler[]>(`${this.baseUrl}/pendientes`);
  }

actualizarEstado(id: number, estado: string): Observable<Alquiler> {
  return this.http.put<Alquiler>(`${this.baseUrl}/actualizarestado`, null, {
    params: { idAlquiler: `${id}`, estado }
  });
}
  
obtenerAlquilerPorPlaca(placa: string): Observable<Alquiler> {
  return this.http.get<Alquiler>(`${this.baseUrl}/buscarAlquiler`, {
    params: { placa }
  });
}
obtenerAlquilerPorId(id:number): Observable<Alquiler>{
  return this.http.get<Alquiler>(`${this.baseUrl}/buscarAlquilerPorId `,
    {
      params: { id }
    }
  );

}

  buscarVehiculoPorIdAlquiler(idAlquiler: number): Observable<Vehiculo> {
    return this.http.get<Vehiculo>(`${this.baseUrl}/buscarVehiculoporAlquilerId`,{
      params: {idAlquiler}
    });
  }

   
}

