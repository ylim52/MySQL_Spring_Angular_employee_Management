import { Injectable } from '@angular/core';
import { CanActivate, CanActivateChild,  ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Router } from "@angular/router";
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UservalidationService implements CanActivate, CanActivateChild{

  private cookieValue:string;

  constructor(private cookieService: CookieService,
    private router:Router) {
      this.cookieValue = this.cookieService.get("role");
  }

  canActivate(route:ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if (this.cookieValue === "hr"){
        window.alert("Hiring Manager cannot view Employee Page");
        this.router.navigate(['hr/home']);
        return false;
      }else{
        return true;
      }
    }

  canActivateChild(route:ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if (this.cookieValue === "hr"){
        window.alert("Hiring Manager cannot view Employee Page");
        this.router.navigate(['hr/home']);
        return false;
      }else{
        return true;
      }
  }
}
