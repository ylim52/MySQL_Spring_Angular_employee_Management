import { Injectable } from '@angular/core';
import { PersonService } from 'src/app/employee/person.service';
import { catchError } from 'rxjs/operators';
import { empty } from 'rxjs';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HrHomeResolverService {

  constructor(private personService: PersonService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.personService.getEmployees().pipe(
      catchError((error) => {
        return empty();
      })
    );
  }
}
