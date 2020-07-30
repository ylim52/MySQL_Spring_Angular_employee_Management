import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/employee/employee.model';
import { ActivatedRoute } from '@angular/router';
import { HrHomeService } from './hr-home.service';

@Component({
  selector: 'app-hr-home',
  templateUrl: './hr-home.component.html',
  styleUrls: ['./hr-home.component.css']
})
export class HrHomeComponent implements OnInit {

  employeeList: Employee[];

 constructor(private service: HrHomeService, private route: ActivatedRoute) { }

  ngOnInit() {
     this.service.getEmployees().subscribe(data => {
       this.employeeList = data;
     }); 
  }

  getDayLeft(theDate : string) : number {
    let newDate = new Date(theDate);
    return Math.round((newDate.getTime() - new Date().getTime() ) / (1000 * 60 * 60 * 24)) ;
 }

  uploadFile($event) {
    console.log($event.target.files[0]);
}

getItems() {
  return this.employeeList.filter((employeeList) => this.getDayLeft(employeeList.visaEnd) <= 100 && this.getDayLeft(employeeList.visaEnd) > 0);
}
}
