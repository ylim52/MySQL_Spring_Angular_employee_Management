import {Employee} from '../../employee/employee.model';

export class VisaStatus {

  id: number;
  visaType: string;
  active: number;
  modificationUser: string;
  createUser: string;
  employee: Employee;
}