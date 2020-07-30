import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { catchError, withLatestFrom } from 'rxjs/operators';
import { empty, Observable } from 'rxjs';
import { OnboardService } from './onboard.service';
import { ApplicationService } from '../hire-page/application-view/application.service';

@Injectable({
  providedIn: 'root'
})
export class AllEmployeeResolverService {

  constructor(private onboardService:OnboardService,
    private applicationService:ApplicationService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.onboardService.getAllEmployee().pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
