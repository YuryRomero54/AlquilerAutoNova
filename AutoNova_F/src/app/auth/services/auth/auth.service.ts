import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';

const BASE_URL="http://localhost:8085";
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }

  register(signUpRequest:any): Observable<any> {
    return this.http.post(BASE_URL+"/api/signUp",signUpRequest);
  }
}
