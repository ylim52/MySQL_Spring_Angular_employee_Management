import { FacilityReportDetail } from '../facility-report-detail/facility-report-detail.model';

export class FacilityReport{
    id: number;
    title: string;
    employeeId: number;
    reportDate: string;
    description: string;
    status: string;
    facilityReportDetail: FacilityReportDetail;
}
