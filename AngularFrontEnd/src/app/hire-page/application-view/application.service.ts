import { Injectable } from '@angular/core';
import { Application } from './application.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(private http: HttpClient) { }

  public getApplication():Observable<Application[]>{
    return this.http.get<Application[]>('/application/getOnboard');
  }

  public getApplicationById(id:string):Observable<Application>{
    return this.http.get<Application>('/application/getId/' + id);
  }

  public updateApplication(application: Application): Observable<any>{
    return this.http.post('application/update', application);
  }
}
