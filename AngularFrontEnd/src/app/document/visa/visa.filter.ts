import { Pipe, PipeTransform, Injectable } from '@angular/core';

@Pipe({
  name: 'filter'
})
@Injectable()
export class VisaFilter implements PipeTransform {
  transform(items: any[], field: string, value: string): any[] {
    if (!items) {
      return [];
    }
    if (!field || !value) {
      return items;
    }

    return items.filter(singleItem =>
      singleItem.id.toString().toLowerCase().includes(value.toString().toLowerCase()));
  }
}
