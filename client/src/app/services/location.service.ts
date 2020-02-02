import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfig } from '../configs/app-config';

@Injectable()
export class LocationService {

  private readonly apiUrl = AppConfig.API_URL;

  constructor(private http: HttpClient) {
  }

  public create(location: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/location`, location);
  }

  public update(id: any, location: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/location/${id}`, location);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/location/${id}`);
  }

  public list(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/location`);
  }

  public findById(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/location/${id}`);
  }

  public search(address: any): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/location/search?address=${address}`);
  }
}

