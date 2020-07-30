import { Injectable } from '@angular/core';
import { VisaStatus } from './visa.model';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams, HttpResponse} from '@angular/common/http';
import {Application} from './application.model';
import {PersonalDocument} from './personal-doc.model';


@Injectable({
  providedIn: 'root'
})
export class VisaService {

  constructor(private http: HttpClient) { }

  public getAllVisa(): Observable<VisaStatus[]> {
    return this.http.get<VisaStatus[]>('/visa');
  }

  public getVisaById(id): Observable<VisaStatus> {
    return this.http.get<VisaStatus>('/visa/id',
      {params: new HttpParams().set('id', id)});
  }

  public getApplicationById(id): Observable<Application> {
    return this.http.get<Application>('/visa/status',
      {params: new HttpParams().set('id', id)});
  }


  public getPersonalDocumentsById(id): Observable<PersonalDocument[]> {
    return this.http.get<PersonalDocument[]>('/documentListener/person',
      {params: new HttpParams().set('id', id)});
  }

  public updateVisa(visa: VisaStatus): Observable<any> {
    return this.http.post('/visa/update', visa);
  }

  upload(fileType: string, file: File, id: string): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('fileType', fileType);
    formData.append('file', file);
    formData.append('id', id);
    return this.http.post('/documentListener/upload', formData);
  }

  downloadUser(filePath: string): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Accept', 'application/pdf');
    return this.http.get('/documentListener/download-user',
      { headers, responseType: 'blob', params: new HttpParams().set('filePath', filePath)});
  }

  downloadForm(fileName: string): Observable<Blob> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json', responseType : 'blob'});

    return this.http.get<Blob>('/documentListener/download-form', { headers, responseType :
        'blob' as 'json', params: new HttpParams().set('fileName', fileName)});
  }

  approveUser(id: string){
    const formData: FormData = new FormData();
    formData.append('id', id);
    return this.http.post('/documentListener/approve', formData);
  }

  rejectUser(id: string){
    const formData: FormData = new FormData();
    formData.append('id', id);
    return this.http.post('/documentListener/reject', formData);
  }

}
