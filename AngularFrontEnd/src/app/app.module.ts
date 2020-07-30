import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PersonService} from './employee/person.service';
import { EmployeeFilter } from '../app/employee/employee-filter';
import { EmployeeProfileComponent } from './employee/employee-profile/employee-profile.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';

import { VisaListComponent } from './document/visa/visa-list/visa-list.component';
import { VisaDetailComponent } from './document/visa/visa-detail/visa-detail.component';
import { VisaFilter } from './document/visa/visa.filter';

import { FacilityComponent } from './facility/facility.component';
import { FacilityReportComponent } from './facility/facility-report/facility-report.component';
import { FacilityReportDetailComponent } from './facility/facility-report-detail/facility-report-detail.component';
import { UserHomeComponent } from './home/user-home/user-home.component';
import { HrHomeComponent } from './home/hr-home/hr-home.component';

import { HouseListComponent } from './house/house-list/house-list.component';
import { HouseDetailComponent } from './house/house-detail/house-detail.component';
import { NavbarComponent } from './home/hr-home/hr-nav-bar/navbar.component';
import { UserEmployeeComponent } from './employee/user-employee/user-employee.component';
import { UserVisaComponent } from './document/visa/user-visa/user-visa.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatChipsModule } from '@angular/material/chips';
import { HirePageComponent } from './hire-page/hire-page.component';
import { GenerateTokenComponent } from './hire-page/generate-token/generate-token.component';
import { ApplicationViewComponent } from './hire-page/application-view/application-view.component';
import { UserNavBarComponent } from './home/user-home/user-nav-bar/user-nav-bar.component';
import { CookieService } from 'ngx-cookie-service';
import { HrMainComponent } from './home/hr-main/hr-main.component';
import { OnboardComponent } from './onboard/onboard.component';
import { UserFacilityReportComponent } from './house/user-facility-report/user-facility-report.component';
import { UserHouseComponent } from './house/user-house/user-house.component';
import { CheckOnboardComponent } from './check-onboard/check-onboard.component';
import { PendingComponent } from './check-onboard/pending/pending.component';
import { SubdetailComponent } from './hire-page/application-view/subdetail/subdetail.component';
import { WildcardRedirectComponent } from './routeGuard/wildcard-redirect/wildcard-redirect.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeProfileComponent,
    EmployeeListComponent,
    EmployeeFilter,
    VisaFilter,
    FacilityComponent,
    FacilityReportComponent,
    FacilityReportDetailComponent,
    VisaListComponent,
    VisaDetailComponent,
    UserHomeComponent,
    HrHomeComponent,
    HouseListComponent,
    HouseDetailComponent,
    NavbarComponent,
    HirePageComponent,
    GenerateTokenComponent,
    ApplicationViewComponent,
    UserNavBarComponent,
    UserEmployeeComponent,
    UserVisaComponent,
    HrMainComponent,
    OnboardComponent,
    UserFacilityReportComponent,
    UserHouseComponent,
    CheckOnboardComponent,
    PendingComponent,
    SubdetailComponent,
    WildcardRedirectComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatCheckboxModule,
    MatChipsModule,
  ],
  providers: [PersonService, CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
