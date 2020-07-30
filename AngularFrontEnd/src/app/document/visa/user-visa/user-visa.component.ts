import { Component, OnInit } from '@angular/core';
import {PersonService} from '../../../employee/person.service';
import {VisaService} from '../visa.service';
import {Employee} from '../../../employee/employee.model';
import {Application} from '../application.model';
import {VisaStatus} from '../visa.model';
import { CookieService } from 'ngx-cookie-service';
import {PersonalDocument} from '../personal-doc.model';


@Component({
  selector: 'app-user-visa',
  templateUrl: './user-visa.component.html',
  styleUrls: ['./user-visa.component.css']
})
export class UserVisaComponent implements OnInit {

  check: boolean;
  optReceipt: boolean;
  i983: boolean;
  i20: boolean;
  optEAD: boolean;
  updated: boolean;

  constructor(private cookieService: CookieService, private personService: PersonService, private visaService: VisaService) { }

  visa: VisaStatus;
  application: Application;
  personalDocuments: PersonalDocument[];
  selectedFiles: FileList;
  employee: Employee;
  ID = this.cookieService.get('userID');
  ngOnInit(): void {

    this.check = false;
    this.optReceipt =  true;
    this.i983 =  true;
    this.i20 = true;
    this.optEAD = true;
    this.updated = true;

    this.personService.getEmployeeById(this.ID)
      .subscribe(data => {
        this.employee = data;
      });

    this.visaService.getApplicationById(this.ID)
      .subscribe(data => {
        this.application = data;
      });

    this.visaService.getPersonalDocumentsById(this.ID)
      .subscribe(data => {
        this.personalDocuments = data;
      });

    this.visaService.getVisaById(this.ID)
      .subscribe(data => {
        this.visa = data;
      });

  }

  checkErrors(){
    if (this.application.type.includes('RECEIPT') && this.application.status.includes('Active')){
      this.optReceipt = false;
      this.check = true;
    }
    else if (this.application.type.includes('I-983') && this.application.status.includes('Active')) {
      this.i983 = false;
      this.check = true;
    }
    else if (this.application.type.includes('I-20') && this.application.status.includes('Active')) {
      this.i20 = false;
      this.check = true;
    }
    else if (this.application.type.includes('EAD') && this.application.status.includes('Active')) {
      this.optEAD = false;
      this.check = true;
    }
    else{
      this.updated = false;
      this.check = true;
    }
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  public submitOPTReceipt(){
    this.visaService.upload('OPT-RECEIPT', this.selectedFiles.item(0), this.cookieService.get('userID'))
      .subscribe(data => console.log(data));
    location.reload();
  }
  public submitI983(){
    this.visaService.upload('I-983', this.selectedFiles.item(0), this.cookieService.get('userID'))
      .subscribe(data => console.log(data));
    location.reload();
  }
  public submitI20(){
    this.visaService.upload('I-20', this.selectedFiles.item(0), this.cookieService.get('userID'))
      .subscribe(data => console.log(data));
    location.reload();
  }
  public submitOPTead(){
    this.visaService.upload('OPT-EAD', this.selectedFiles.item(0), this.cookieService.get('userID'))
      .subscribe(data => console.log(data));
    location.reload();
  }

  public downloadI983(){
    this.visaService.downloadForm('I-983_Form.pdf')
      .subscribe(data => {
        const file = new Blob([data], { type: 'application/pdf' });
        const fileURL = URL.createObjectURL(file);
        window.open(fileURL);
      });
  }

  public downloadI983sample(){
    this.visaService.downloadForm('I-983_Sample.pdf')
      .subscribe( (data: Blob) => {
          const file = new Blob([data], { type: 'application/pdf' });
          const fileURL = URL.createObjectURL(file);
          window.open(fileURL);
        },
        (error) => {
          console.log('getPDF error: ', error);
        }
      );
  }

  public downloadI20(){
    this.visaService.downloadForm('I-20_Form.pdf')
      .subscribe( (data: Blob) => {
          const file = new Blob([data], { type: 'application/pdf' });
          const fileURL = URL.createObjectURL(file);
          window.open(fileURL);
        },
        (error) => {
          console.log('getPDF error: ', error);
        }
      );
  }

  public downloadUser(filePath: string){
    this.visaService.downloadUser(filePath)
      .subscribe( (data: Blob) => {
          const file = new Blob([data], { type: 'application/pdf' });
          const fileURL = URL.createObjectURL(file);
          window.open(fileURL);
        },
        (error) => {
          console.log('getPDF error: ', error);
        }
      );
  }

}
