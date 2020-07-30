import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-wildcard-redirect',
  templateUrl: './wildcard-redirect.component.html',
  styleUrls: ['./wildcard-redirect.component.css']
})
export class WildcardRedirectComponent implements OnInit {

  role:string;

  constructor(private cookieService: CookieService,
    private router: Router) { }

  ngOnInit(): void {
    this.role = this.cookieService.get("role");
    if(this.role === 'hr'){
      this.gotoHR();
    }else{
      this.gotoEmployee();
    }
  }

  gotoEmployee(){
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    };
    this.router.navigate(['user/home']);
  }

  gotoHR(){
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    };
    this.router.navigate(['hr/home']);
  }


}
