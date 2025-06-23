import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Gestion {
  id_gestion: number;
  fecha_gestion: string;
  observaciones: string;
  administrador: {
    id_administrador: number;
  };
  alquiler: {
    id_alquiler: number;
  };
}


@Injectable({
  providedIn: 'root'
})
export class GestionesService {
  private baseUrl = 'http://localhost:8085/api/gestion-alquiler';  // Ajusta si tu puerto cambia

  constructor(private http: HttpClient) {}

  // 👉 Registrar una nueva gestión
  registrarGestion(body: {
    idAdmin: number;
    idAlquiler: number;
    observaciones: string;
  }): Observable<Gestion> {
    return this.http.post<Gestion>(`${this.baseUrl}/registrarGestion`, body);
  }

  // 👉 Obtener gestiones por ID de alquiler (ya lo tenías)
  obtenerGestionesPorAlquiler(idAlquiler: number): Observable<Gestion[]> {
    return this.http.get<Gestion[]>(`${this.baseUrl}/historial`, {
      params: { idAlquiler: idAlquiler.toString() }
    });
  }

  // ✅ Nuevo: Obtener gestiones por ID de administrador
  obtenerGestionesPorAdmin(idAdmin: number): Observable<Gestion[]> {
    return this.http.get<Gestion[]>(`${this.baseUrl}/historial-admin`, {
      params: { idAdmin: idAdmin.toString() }
    });
  }
  obtenerTodasLasGestiones(): Observable<Gestion[]> {
  return this.http.get<Gestion[]>(`${this.baseUrl}/todas`);
}

}
