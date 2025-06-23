import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl = 'http://localhost:8085/api/usuario/login'; 

  constructor(private http: HttpClient) {}

  login(datos: any): Observable<any> {
    return this.http.post(this.apiUrl, datos);
  }
}
