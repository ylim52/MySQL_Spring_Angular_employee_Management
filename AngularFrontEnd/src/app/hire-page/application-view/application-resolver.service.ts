import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { ApplicationService } from './application.service';
import { catchError } from 'rxjs/operators';
import { empty } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApplicationResolverService implements Resolve<any>{

  constructor(private applicationService:ApplicationService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.applicationService.getApplication().pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
