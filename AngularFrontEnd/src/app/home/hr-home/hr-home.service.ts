import { Injectable } from '@angular/core';
import {  HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/employee/employee.model';

@Injectable({
  providedIn: 'root'
})

export class HrHomeService {

 constructor(private http: HttpClient){}

   public getEmployees(): Observable<Employee[]> {
     return this.http.get<Employee[]>('/home');
   } 
}
