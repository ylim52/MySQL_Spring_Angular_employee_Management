import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders }    from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  constructor(public http:HttpClient) { }

  onSubmit(file:File, id:string):Observable<{}>{
    let formdata: FormData = new FormData();
    formdata.append('file', file);
    formdata.append('id', id);
    let address = 'documentListener/addAvatar';
    return this.http.post(address, formdata);
  }
}
