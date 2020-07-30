import { Component, OnInit } from '@angular/core';
import { Token } from '../token.model';
import { TokenService } from '../token.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-generate-token',
  templateUrl: './generate-token.component.html',
  styleUrls: ['./generate-token.component.css']
})
export class GenerateTokenComponent implements OnInit {

  tokens: Token[];
  email: string;
  showDetail = false;

  constructor(private tokenService: TokenService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe((data:{tokens:any}) => {
      this.tokens = data.tokens;
    });
  }

  public generateToken(){
      if(this.email === "" || this.email === undefined){
        window.alert("Please Enter Email address");
      }else{
        let token = new Token();
        token.email = this.email;
        token.createdBy = 1;
        this.tokenService.createToken(token).subscribe(result =>
        this.gotoHirePage());
      }
  }

  gotoHirePage(){
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    }
    this.router.navigate(['hr/hire']);
  }

  display(){
    this.showDetail = !this.showDetail;
  }

}
