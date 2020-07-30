import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { OnboardService } from './onboard.service';
import { catchError } from 'rxjs/operators';
import { empty } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class OnboardResolverService implements Resolve<any>{

  currentID:string;

  constructor(private onboardService:OnboardService,
    private cookieService: CookieService) { 
      this.currentID = this.cookieService.get("userID");
    }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.onboardService.getEmployee(this.currentID).pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
