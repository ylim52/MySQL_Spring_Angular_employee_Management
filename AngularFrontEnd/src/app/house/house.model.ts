import { Employee } from '../employee/employee.model';
import { Facility } from '../facility/facility.model';
import { FacilityReport } from '../facility/facility-report/facility-report.model';

 export class House{
  isEditable: boolean = false;
  //house
  id: number;
  address: string;
  occupancy: number;
  contactID: number;

 //employee info
  employees: Employee[];

  //facility info
  facilities: Facility[];
 }
