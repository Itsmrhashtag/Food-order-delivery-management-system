import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = 'http://localhost:8080/api/v1/orders';

  constructor(private http: HttpClient) {}

  checkout(userId: string, name:string, address:string, access_token: string, paymentMethodId: string) {
    const headers = new HttpHeaders({
      Authorization: 'Bearer ' + access_token
    });
    const params = new HttpParams()
      .set('userId', userId)
      .set('name', name)
      .set('address', address);
console.log(name);
console.log(address);
    return this.http.post(`${this.apiUrl}/checkout`, { paymentMethodId }, { headers, params });
  }
}
