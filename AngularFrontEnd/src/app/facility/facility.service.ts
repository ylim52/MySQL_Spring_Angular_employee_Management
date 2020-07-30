import { Injectable } from '@angular/core';
import { FacilityReport } from './facility-report/facility-report.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { FacilityReportDetail } from './facility-report-detail/facility-report-detail.model';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  constructor(private http: HttpClient) { }

  public updateComments(facilityReportDetail: FacilityReportDetail): Observable<FacilityReportDetail> {
    console.log('Service level reached');
    return this.http.post<FacilityReportDetail>('/house/update-comments', facilityReportDetail);
  }

  public addReport(facilityReport: FacilityReport): Observable<FacilityReport> {
    console.log('Service level reached');
    return this.http.post<FacilityReport>('/house/add-report', facilityReport);
  }
}
