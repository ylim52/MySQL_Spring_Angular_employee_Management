import { Component, OnInit } from '@angular/core';
import { VisaStatus } from '../visa.model';
import { VisaService } from '../visa.service';
import {ActivatedRoute} from '@angular/router';
import {Application} from '../application.model';
import { CookieService } from 'ngx-cookie-service';
import {PersonalDocument} from '../personal-doc.model';

@Component({
  selector: 'app-visa-detail',
  templateUrl: './visa-detail.component.html',
  styleUrls: ['./visa-detail.component.css']
})
export class VisaDetailComponent implements OnInit {

  ID: number;
  pending: boolean;
  visa: VisaStatus;
  application: Application;
  personalDocuments: PersonalDocument[];
  constructor(private cookieService: CookieService, private visaService: VisaService, private route: ActivatedRoute) { }



  ngOnInit(): void {
    this.pending = true;
    this.route.params.subscribe(params => this.ID = params.id);

    this.route.params.subscribe(params => { this.visaService.getVisaById(params.id)
      .subscribe(data => {
        this.visa = data;
      }); } );

    this.route.params.subscribe(params => { this.visaService.getApplicationById(params.id)
      .subscribe(data => {
        this.application = data;
        if (this.application.status.includes('Pending')){
          this.pending = false;
        }
      }); } );

    this.route.params.subscribe(params => { this.visaService.getPersonalDocumentsById(params.id)
      .subscribe(data => {
        this.personalDocuments = data;
      }); } );

  }

  public download(){
    this.visaService.downloadUser(this.personalDocuments.filter(x => x.title.includes(this.application.type))[0].path)
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

  public approve(){
    this.visaService.approveUser(this.ID.toString())
      .subscribe( (data) =>
         console.log(data)
      );
    location.reload();
  }

  public reject(){
    this.visaService.rejectUser(this.ID.toString())
      .subscribe( (data) =>
        console.log(data)
      );
    location.reload();
  }

}
