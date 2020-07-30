import { Address } from '../house/address.model';

export class Contact {
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
  relationship: string;
  title: string;
  isReference: number;
  isEmergency: number;
  isLandlord: number;
}
