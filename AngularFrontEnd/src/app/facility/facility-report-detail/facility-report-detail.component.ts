import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HouseService } from 'src/app/house/house.service';
import { House } from 'src/app/house/house.model';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-facility-report-detail',
  templateUrl: './facility-report-detail.component.html',
  styleUrls: ['./facility-report-detail.component.css']
})
export class FacilityReportDetailComponent implements OnInit {
  houseList: House[];
  house: House;
  constructor(private route: ActivatedRoute, private houseService: HouseService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => { this.houseService.getHouseById(params.id)
      .subscribe(data => {
        this.house = data;
      }); } );
}

  getItems() {
    return this.houseList.filter((houseList) => houseList.id === 1);
  }
}

