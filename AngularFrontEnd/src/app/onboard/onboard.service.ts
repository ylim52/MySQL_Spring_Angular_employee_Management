import { Injectable } from '@angular/core';
import { Employee } from '../employee/employee.model';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class OnboardService {

  constructor(private http: HttpClient) {
    
  }

  public getAllEmployee():Observable<Employee[]>{
    return this.http.get<Employee[]>('/employee');
  }

  public getEmployee(id:string): Observable<Employee> {
    return this.http.get<Employee>('/getEmployee/' + id);
  }

  public updateEmployee(employee: Employee): Observable<any>{
    return this.http.post('/updateEmployee',employee);
  }

  public uploadAvatar(fileType: string, file: File, id:string):Observable<any>{
    const formData: FormData = new FormData();
    formData.append('fileType', fileType);
    formData.append('file', file);
    formData.append('id', id);
    return this.http.post('/documentListener/uploadFile', formData);
  }

  public uploadFile(fileType: string, file: File, id:string):Observable<any>{
    const formData: FormData = new FormData();
    formData.append('fileType', fileType);
    formData.append('file', file);
    formData.append('id', id);
    return this.http.post('/documentListener/upload', formData);
  }

}
