import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { ApplicationService } from './application.service';
import { catchError } from 'rxjs/operators';
import { empty } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class SingleApplicationResolverService {

  currentID: string;

  constructor(private applicationService:ApplicationService,
    private cookieService: CookieService,) {
    this.currentID = this.cookieService.get("userID");
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.applicationService.getApplicationById(this.currentID).pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
