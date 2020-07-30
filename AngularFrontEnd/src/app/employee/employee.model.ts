import { VisaStatus } from '../document/visa/visa.model';
import { FacilityReport } from '../facility/facility-report/facility-report.model';
import { Address } from '../house/address.model';
import {Application} from '../document/visa/application.model';
import {PersonalDocument} from '../document/visa/personal-doc.model';

export class Employee {

  id: number;
  firstName: string;
  lastName: string;
  middleName: string;
  email: string;
  cellPhone: string;
  altPhone: string;
  gender: string;
  ssn: string;
  dob: string;
  address: Address;
  title: string;
  managerId: number;
  startDate: string;
  endDate: string;
  car: string;
  visaID: number;
  visaStart: string;
  visaEnd: string;
  license: string;
  licenseED: string;
  employeeId: number;
  visaStatus: VisaStatus;
  facilityReports: FacilityReport[];
  applicationWorkFlow: Application;
  personalDocument: PersonalDocument;
  avatar: string;
}
