import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {PersonService} from '../person.service';
import { Employee } from '../employee.model';
import {Contact} from '../contact.model';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-user-employee',
  templateUrl: './user-employee.component.html',
  styleUrls: ['./user-employee.component.css']
})
export class UserEmployeeComponent implements OnInit {

  form: FormGroup;

  displayN: boolean;
  updateN: boolean;

  displayA: boolean;
  updateA: boolean;

  displayC: boolean;
  updateC: boolean;

  displayE: boolean;
  updateE: boolean;

  displayEC: boolean;
  updateEC: boolean;

  displayD: boolean;
  updateD: boolean;

  ID = this.cookieService.get('userID');

  constructor(private cookieService: CookieService, private formBuilder: FormBuilder, private personService: PersonService) { }
  employee: Employee;
  contact: Contact;
  ngOnInit(): void {

    this.displayN = false;
    this.updateN = true;
    this.displayA = false;
    this.updateA = true;
    this.displayE = false;
    this.updateE = true;
    this.displayD = false;
    this.updateD = true;

    this.personService.getEmployeeById(this.ID)
      .subscribe(data => {
        this.employee = data;
      });

    this.personService.getContactById(this.ID)
      .subscribe(data => {
        this.contact = data;
      });

    this.form = this.formBuilder.group({
      first: ' ',
      middle: ' ',
      last: ' ',
      address1: ' ',
      address2: ' ',
      city: ' ',
      state: ' ',
      zipCode: ' ',
      title: ' ',
      startDate: ' ',
      endDate: ' ',
      managerID: ' ',
      ssn: ' ',
      license: ' ',
      exp: ' '
    });
  }

  updateName(){
    this.displayN = true;
    this.updateN = false;
  }
  cancelName(){
    if (confirm('Discard these changes?')){
      this.displayN = false;
      this.updateN = true;
    }
  }
  async submitName(){
    this.employee.firstName = this.form.value.first;
    this.employee.middleName = this.form.value.middle;
    this.employee.lastName = this.form.value.last;
    this.personService.updateName(this.employee).subscribe(data => {
      if (data != null){
        console.log(data);
        this.displayN = false;
        this.updateN = true;
      }
      else{
        console.log('error updating address');
        window.alert('Error, try again');
      }
    });
  }

  updateAddress(){
    this.displayA = true;
    this.updateA = false;
  }
  cancelAddress(){
    if (confirm('Discard these changes?')){
      this.displayA = false;
      this.updateA = true;
    }
  }
  async submitAddress(){
    this.employee.address.addressLine1 = this.form.value.address1;
    this.employee.address.addressLine2 = this.form.value.address2;
    this.employee.address.city = this.form.value.city;
    this.employee.address.stateName = this.form.value.state;
    this.employee.address.zipcode = this.form.value.zipCode;
    this.personService.updateAddress(this.employee).subscribe(data => {
      if (data != null){
        console.log(data);
        this.displayA = false;
        this.updateA = true;
      }
      else{
        console.log('error updating address');
        window.alert('Error, try again');
      }
    });
  }

  updateContact(){
    this.displayN = true;
    this.updateN = false;
  }
  cancelContact(){
    if (confirm('Discard these changes?')){
      this.displayN = false;
      this.updateN = true;
    }
  }
  async submitContact(){
    this.employee.firstName = this.form.value.first;
    this.employee.middleName = this.form.value.middle;
    this.employee.lastName = this.form.value.last;
    this.personService.updateName(this.employee).subscribe(data => console.log(data));
    this.displayN = false;
    this.updateN = true;
  }

  updateEmployment(){
    this.displayE = true;
    this.updateE = false;
  }
  cancelEmployment(){
    if (confirm('Discard these changes?')){
      this.displayE = false;
      this.updateE = true;
    }
  }
  async submitEmployment(){
    this.employee.title = this.form.value.title;
    this.employee.managerId = this.form.value.managerID;
    this.employee.startDate = this.form.value.startDate;
    this.employee.endDate = this.form.value.endDate;
    this.personService.updateEmployment(this.employee).subscribe(data => {
      if (data != null){
        console.log(data);
        this.displayE = false;
        this.updateE = true;
      }
      else{
        console.log('error updating address');
        window.alert('Error, try again');
      }
    });
  }

  updateEmergency(){
    this.displayN = true;
    this.updateN = false;
  }
  cancelEmergency(){
    if (confirm('Discard these changes?')){
      this.displayN = false;
      this.updateN = true;
    }
  }
  async submitEmergency(){
    this.employee.firstName = this.form.value.first;
    this.employee.middleName = this.form.value.middle;
    this.employee.lastName = this.form.value.last;
    this.personService.updateName(this.employee).subscribe(data => console.log(data));
    this.displayN = false;
    this.updateN = true;
  }

  updateDocument(){
    this.displayD = true;
    this.updateD = false;
  }
  cancelDocument(){
    if (confirm('Discard these changes?')){
      this.displayD = false;
      this.updateD = true;
    }
  }
  async submitDocument(){
    this.employee.ssn = this.form.value.ssn;
    this.employee.license = this.form.value.license;
    this.employee.licenseED = this.form.value.exp;
    this.personService.updateDocument(this.employee).subscribe(data => {
      if (data != null){
        console.log(data);
        this.displayD = false;
        this.updateD = true;
      }
      else{
        console.log('error updating address');
        window.alert('Error, try again');
      }
    });
  }

}
