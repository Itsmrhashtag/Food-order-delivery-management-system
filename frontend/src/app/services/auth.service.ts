import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

interface LoginResponse {
  user: any;
  jwt: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/v1/auth';
  loggedIn = new EventEmitter<boolean>();

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, { email, password }).pipe(
      tap((response) => {
        console.log('User ID:', response.user.id);
        console.log('authority:',response.user.authorities[0].authority);
        localStorage.setItem('authority', response.user.authorities[0].authority);
        localStorage.setItem('access_token', response.jwt);
        localStorage.setItem('user_id', response.user.id);
        this.loggedIn.emit(true);
      })
    );
  }

  register(email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, { email, password });
  }
  registerAdmin(email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/admin/register`, { email, password });
  }
  registerDelivery(email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/delivery/register`, { email, password });
  }
}
