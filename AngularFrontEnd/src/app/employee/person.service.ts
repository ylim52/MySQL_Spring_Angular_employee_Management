import { Injectable } from '@angular/core';
import { Employee } from './employee.model';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Contact} from './contact.model';


@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) { }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>('/employee');
  }

  public getEmployeeById(id): Observable<Employee> {
    return this.http.get<Employee>('/employee/id',
      {params: new HttpParams().set('id', id)});
  }

  public getContactById(id): Observable<Contact> {
    return this.http.get<Contact>('/contact/id',
      {params: new HttpParams().set('id', id)});
  }

  public updateName(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>('/employee/update-name', employee);
  }

  public updateAddress(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>('/employee/update-address', employee);
  }

  public updateEmployment(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>('/employee/update-employment', employee);
  }

  public updateDocument(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>('/employee/update-document', employee);
  }

}

