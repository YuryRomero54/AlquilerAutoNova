import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {
  private baseUrl  = 'http://localhost:8085/api/alquiler'; // ← CORRECTO según Postman


  constructor(private http: HttpClient) {}

  obtenerReservasPorUsuario(idUsuario: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/usuario/${idUsuario}`);
  }

  cancelarReserva(idUsuario: number, idAlquiler: number): Observable<any> {
    const datos = { idUsuario, idAlquiler };
    return this.http.post(`${this.baseUrl}/cancelar`, datos); // ← CORRECTO según Postman
  }
}

  

