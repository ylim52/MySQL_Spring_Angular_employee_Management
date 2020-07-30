import { Component, OnInit } from '@angular/core';
import { VisaStatus } from '../visa.model';
import { VisaService } from '../visa.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-visa-list',
  templateUrl: './visa-list.component.html',
  styleUrls: ['./visa-list.component.css']
})
export class VisaListComponent implements OnInit {

  sorted = false;
  searchText: string;
  visaList: VisaStatus[];

  constructor(private visaService: VisaService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.visaService.getAllVisa()
      .subscribe(data => {
        this.visaList = data;
      });
  }
  sort(type: string) {
    if (this.sorted === false) {
      console.log(this.visaList.sort((a, b) => a[type] > b[type] ? 1 : a[type] < b[type] ? -1 : 0));
      this.sorted = true;
    }
    else {
      console.log(this.visaList.sort((a, b) => a[type] > b[type] ? -1 : a[type] < b[type] ? 1 : 0));
      this.sorted = false;
    }
  }
}
