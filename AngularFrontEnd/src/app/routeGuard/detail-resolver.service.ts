import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { TokenService } from '../hire-page/token.service';
import { catchError } from 'rxjs/operators';
import { empty } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DetailResolverService implements Resolve<any>{

  constructor(private tokenService: TokenService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.tokenService.getToken().pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
