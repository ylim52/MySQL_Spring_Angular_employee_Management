import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { PersonService } from '../person.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  sorted = false;
  searchText: string;

  employeeList: Employee[];

  constructor(private employeeService: PersonService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.employeeService.getEmployees()
      .subscribe(data => {
        this.employeeList = data;
      });
  }

  sort(type: string) {
    if (this.sorted === false) {
      console.log(this.employeeList.sort((a, b) => a[type] > b[type] ? 1 : a[type] < b[type] ? -1 : 0));
      this.sorted = true;
    }
    else {
      console.log(this.employeeList.sort((a, b) => a[type] > b[type] ? -1 : a[type] < b[type] ? 1 : 0));
      this.sorted = false;
    }
  }

}

