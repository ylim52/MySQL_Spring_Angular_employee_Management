import { Pipe, PipeTransform, Injectable } from '@angular/core';

@Pipe({
  name: 'filter'
})
@Injectable()
export class EmployeeFilter implements PipeTransform {
  transform(items: any[], field: string, value: string): any[] {
    if (!items) {
      return [];
    }
    if (!field || !value) {
      return items;
    }

    return Array.from(new Set(items.filter(singleItem =>
      singleItem.id.toString().toLowerCase().includes(value.toString().toLowerCase()))
      .concat(items.filter(singleItem =>
        singleItem.firstName.toString().toLowerCase().includes(value.toString().toLowerCase())))
      .concat(items.filter(singleItem =>
        singleItem.middleName.toString().toLowerCase().includes(value.toString().toLowerCase()))
        .concat(items.filter(singleItem =>
          singleItem.lastName.toString().toLowerCase().includes(value.toString().toLowerCase()))))));
  }
}
