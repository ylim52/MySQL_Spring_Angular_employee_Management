import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { PersonService } from '../person.service';

import { VisaStatus} from '../../document/visa/visa.model';
import { VisaService} from '../../document/visa/visa.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  employee: Employee;

  visa: VisaStatus;

  constructor(private visaService: VisaService,
              private employeeService: PersonService,
              private route: ActivatedRoute){
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => { this.visaService.getVisaById(params.id)
      .subscribe(data => {
        this.visa = data;
      }); } );
    this.route.params.subscribe(params => { this.employeeService.getEmployeeById(params.id)
      .subscribe(data => {
        this.employee = data;
      }); } );
  }
}
