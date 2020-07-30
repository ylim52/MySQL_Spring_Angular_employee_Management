import { Component, OnInit } from '@angular/core';
import { House } from '../house.model';
import { CookieService } from 'ngx-cookie-service';
import { ActivatedRoute } from '@angular/router';
import { HouseService } from '../house.service';

@Component({
  selector: 'app-user-house',
  templateUrl: './user-house.component.html',
  styleUrls: ['./user-house.component.css']
})
export class UserHouseComponent implements OnInit {
  house : House;
  currentHouseID: string;

  constructor(private cookieService: CookieService, private houseservice: HouseService, private route: ActivatedRoute) {
      this.currentHouseID = this.cookieService.get("houseID");
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => { this.houseservice.getHouseById(1)
      .subscribe(data => {
        this.house = data;
      }); } );
  }


}
