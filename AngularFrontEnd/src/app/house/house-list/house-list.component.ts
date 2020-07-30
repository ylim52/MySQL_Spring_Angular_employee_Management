import { Component, OnInit } from '@angular/core';
import { House } from '../house.model';
import { HouseService } from '../house.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-house-list',
  templateUrl: './house-list.component.html',
  styleUrls: ['./house-list.component.css']
})
export class HouseListComponent implements OnInit {
  houseList: House[];

  constructor(private houseService: HouseService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.houseService.getHouses().subscribe(data => {
      this.houseList = data;
      
  });
}
getItems() {
  return this.houseList.filter((houseList) => houseList.contactID === 3);
}
}
 