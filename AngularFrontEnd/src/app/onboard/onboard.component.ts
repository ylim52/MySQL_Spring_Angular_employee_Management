import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee/employee.model';
import { OnboardService } from '../onboard/onboard.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { VisaStatus} from '../document/visa/visa.model';
import { DomSanitizer } from '@angular/platform-browser';
import { Application } from '../document/visa/application.model';


@Component({
  selector: 'app-onboard',
  templateUrl: './onboard.component.html',
  styleUrls: ['./onboard.component.css']
})
export class OnboardComponent implements OnInit {

  currentID: string;
  employee: Employee;
  application:Application;
  visa: VisaStatus;
  isCitizen: boolean;
  hasDriverLicence: boolean;
  selectedAvatar:FileList;
  selectedVisa:FileList;
  selectedLicence:FileList;
  imgsrc :string = 'http://localhost:8081/avatar/avatar.jpg';
  allComments:string[];

  constructor(private onboardService: OnboardService,
    private cookieService: CookieService,
    private router: Router,
    public _d: DomSanitizer,
    private activatedRoute: ActivatedRoute) {
      this.currentID = this.cookieService.get("userID");
    }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe((data:{employee:any}) => {
      this.employee = data.employee;
    });
    this.activatedRoute.data.subscribe((data:{application:any})=>{
      this.application = data.application;
    });
    if(this.employee.visaStatus.visaType === 'GreenCard' ||
    this.employee.visaStatus.visaType === 'Citizen'){
      this.isCitizen = true;
    }else{
      this.isCitizen = false;
    }
    if (this.employee.license.length > 0){
      this.hasDriverLicence = true;
    }else{
      this.hasDriverLicence = false;
    }
    this.allComments = this.application.comments.split("^");
  }

  checkInput(element:any){
    if(element != undefined && element !=''){
      return true;
    }else{
      return false;
    }
  }

  checkValid(){
    if (this.checkInput(this.employee.firstName) && this.checkInput(this.employee.lastName)
    && this.checkInput(this.employee.address.addressLine1) && this.checkInput(this.employee.address.city)
    && this.checkInput(this.employee.address.zipcode) && this.checkInput(this.employee.address.stateName)
    && this.checkInput(this.employee.address.stateAbbr) && this.checkInput(this.employee.cellPhone) 
    && this.checkInput(this.employee.ssn) && this.checkInput(this.employee.dob)){
      if(confirm("Are you sure to submit this application?")){
        this.update();
      }
    }else{
      window.alert("Not all mandatory items were filled");
    }
  }

  update(){
    this.onboardService.updateEmployee(this.employee).subscribe(result =>
      this.gotoPending());
  }

  gotoOnboardPage(){
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    };
    this.router.navigate(['user/onboard']);
  }

  gotoPending(){
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    }
    this.router.navigate(['pendingApplication']);
  }

  trueCitizen(e){
    this.isCitizen = e.target.checked;
  }

  falseCitizen(e){
    this.isCitizen = !e.target.checked;
  }

  trueDriverLicence(e){
    this.hasDriverLicence = e.target.checked;
  }

  falseDriverLicence(e){
    this.hasDriverLicence = !e.target.checked;
  }

  setInitialImg(path:string){
    console.log(path);
    var splitted = path.split("Avatar");
    console.log(splitted);
    this.imgsrc = 'http://localhost:8081/avatar/' + splitted[1];
  }

  selectAvatar(event){
    this.selectedAvatar = event.target.files;
    this.imgsrc = window.URL.createObjectURL(event.srcElement.files[0]);
  }

  public submitAvatar(){
    this.onboardService.uploadAvatar('Avatar', this.selectedAvatar.item(0), this.cookieService.get('userID'))
    .subscribe(data => console.log(data));
  }

  selectVisa(event){
    this.selectedVisa = event.target.files;
  }

  public submitVisa(){
    this.onboardService.uploadFile('Document', this.selectedVisa.item(0), this.cookieService.get('userID'))
    .subscribe(data => console.log(data));
  }

  selectLicence(event){
    this.selectedLicence = event.target.files;
  }

  public submitLicence(){
    this.onboardService.uploadFile('Licence', this.selectedLicence.item(0), this.cookieService.get('userID'))
    .subscribe(data => console.log(data));
  }
}
