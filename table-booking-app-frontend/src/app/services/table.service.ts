import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TableService {
  private apiUrl='http://localhost:8083/api/tables';
  // private bookUrl='http://localhost:8083/api/tables/book/id'

  constructor(private http:HttpClient) { }
  getTables():Observable<any[]>{
    return this.http.get<any[]>(this.apiUrl);
  }
  booktable(id: number):Observable<any>{
    return this.http.post(`${this.apiUrl}/book/${id}`, {});
    
  }
  cancelBooking(id:number):Observable<any>{
    return this.http.post(`${this.apiUrl}/cancel/${id}`,{});
  }
}
