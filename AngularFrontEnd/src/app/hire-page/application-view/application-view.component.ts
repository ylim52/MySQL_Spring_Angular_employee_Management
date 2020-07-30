import { Component, OnInit } from '@angular/core';
import { Application } from './application.model';
import { ApplicationService } from './application.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Employee } from '../../employee/employee.model';
import { OnboardService } from '../../onboard/onboard.service';

@Component({
  selector: 'app-application-view',
  templateUrl: './application-view.component.html',
  styleUrls: ['./application-view.component.css']
})
export class ApplicationViewComponent implements OnInit {

  applications: Application[];
  employees: Employee[];

  constructor(private applicationService:ApplicationService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
      this.activatedRoute.data.subscribe((data:{applications:any}) => {
        this.applications = data.applications;
      });
      this.activatedRoute.data.subscribe((data:{employees:any}) => {
        this.employees = data.employees;
      });
  }
}
