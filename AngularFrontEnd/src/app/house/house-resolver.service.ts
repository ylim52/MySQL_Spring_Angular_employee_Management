import { Injectable } from '@angular/core';
import { HouseService } from './house.service';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { empty } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HouseResolverService {

  constructor(private houseService:HouseService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.houseService.getHouses().pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
