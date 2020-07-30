import { Component, OnInit } from '@angular/core';
import { HouseService } from '../house.service';
import { ActivatedRoute } from '@angular/router';
import { House } from '../house.model';
import { FacilityService } from 'src/app/facility/facility.service';
import { Employee } from 'src/app/employee/employee.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PersonService } from 'src/app/employee/person.service';
import { FacilityReport } from 'src/app/facility/facility-report/facility-report.model';

@Component({
  selector: 'app-user-facility-report',
  templateUrl: './user-facility-report.component.html',
  styleUrls: ['./user-facility-report.component.css']
})
export class UserFacilityReportComponent implements OnInit {

  house: House;
  form1: FormGroup;
  form2: FormGroup;
  employee: Employee;
  displayComments: boolean;
  updateComments: boolean;

  //add INFO
  title: string;
  description: string;
  reportDate: string;
  status: string;;
  displayAddreport: boolean;
  addReport: boolean;

  constructor(private formBuilder: FormBuilder, private houseService: HouseService, private route: ActivatedRoute,
    private personservice: PersonService, private facilityservice: FacilityService ) {
  }

  ngOnInit(): void {

    this.displayComments = false;
    this.updateComments = true;
    this.displayAddreport = false;
    this.addReport = true;

    this.route.params.subscribe(params => { this.houseService.getHouseById(1)
      .subscribe(data => {
        this.house = data;
      }); } );
    
      this.route.params.subscribe(params => { this.personservice.getEmployeeById(1)
        .subscribe(data => {
          this.employee = data;
        }); } );

      this.form1 = this.formBuilder.group({
        comments: '',
        createdDate: ''
  });

       this.form2= this.formBuilder.group({
         title: '',
         description: '',
         reportDate: '06/09/2020',
         status: 'Active'
       });

  }

  report(){
    let report = new FacilityReport();
    report.title = this.form2.value.title;
    report.description = this.form2.value.description;
    report.reportDate = '06/09/2020';
    report.status = 'Active';
    report.employeeId = 1;
    this.house.employees[0].facilityReports.push(report);
   }

  update(){
    this.displayComments = true;
    this.updateComments = false;
  }
  
  cancel(){
    if (confirm('Discard these changes?')){
      this.displayComments = false;
      this.updateComments = true;
    }
  }

  async submit(){
    this.employee.facilityReports[0].facilityReportDetail.comments = this.form1.value.comments;
    this.employee.facilityReports[0].facilityReportDetail.createdDate = this.form1.value.createdDate;
    this.facilityservice.updateComments(this.employee.facilityReports[0].facilityReportDetail).subscribe(data => {
      if (data != null){
        console.log(data);
        this.displayComments = false;
        this.updateComments = true;
      }
      else{
        console.log('error updating address');
        window.alert('Error, try again');
      }
    });
  }

}
