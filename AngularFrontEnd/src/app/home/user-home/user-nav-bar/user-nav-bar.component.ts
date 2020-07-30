import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-user-nav-bar',
  templateUrl: './user-nav-bar.component.html',
  styleUrls: ['./user-nav-bar.component.css']
})
export class UserNavBarComponent implements OnInit {

  username:string;

  constructor(private cookieService: CookieService) { }

  ngOnInit(): void {
    this.username = this.cookieService.get("username");
  }

}
