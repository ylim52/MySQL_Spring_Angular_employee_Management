import { Component, OnInit } from '@angular/core';
import { House } from '../house.model';
import { HouseService } from '../house.service';
import { ActivatedRoute } from '@angular/router';
import { Facility } from 'src/app/facility/facility.model';
import { FacilityReport } from 'src/app/facility/facility-report/facility-report.model';
import { MatDialog } from '@angular/material/dialog';
import { FacilityReportDetailComponent } from 'src/app/facility/facility-report-detail/facility-report-detail.component';
import { FormGroup, FormBuilder } from '@angular/forms';
import { FacilityService } from 'src/app/facility/facility.service';
import { PersonService } from 'src/app/employee/person.service';
import { Employee } from 'src/app/employee/employee.model';

@Component({
  selector: 'app-house-detail',
  templateUrl: './house-detail.component.html',
  styleUrls: ['./house-detail.component.css']
})
export class HouseDetailComponent implements OnInit {
  house: House;
  facilities: Facility[];
  form: FormGroup;
  employee: Employee;
  displayComments: boolean;
  updateComments: boolean;


  constructor(private formBuilder: FormBuilder, private houseService: HouseService, private route: ActivatedRoute,
    private personservice: PersonService, private facilityservice: FacilityService ) {
  }

  ngOnInit(): void {

    this.displayComments = false;
    this.updateComments = true;

    this.route.params.subscribe(params => { this.houseService.getHouseById(params.id)
      .subscribe(data => {
        this.house = data;
      }); } );
    
      this.route.params.subscribe(params => { this.personservice.getEmployeeById(params.id)
        .subscribe(data => {
          this.employee = data;
        }); } );

      this.form = this.formBuilder.group({
        comments: '',
        createdDate: ''
  });
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
    this.employee.facilityReports[0].facilityReportDetail.comments = this.form.value.comments;
    this.employee.facilityReports[0].facilityReportDetail.createdDate = this.form.value.createdDate;
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


