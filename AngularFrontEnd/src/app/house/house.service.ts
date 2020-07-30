import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { House } from './house.model';

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  constructor(private http: HttpClient) { }

  public getHouses(): Observable<House[]>{
    return this.http.get<House[]>('/house');
  }

  public getHouseById(id): Observable<House>{
    return this.http.get<House>('/house/id',
    {params: new HttpParams().set('id', id)});
  }
}
 