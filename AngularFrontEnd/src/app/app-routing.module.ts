import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { EmployeeProfileComponent } from './employee/employee-profile/employee-profile.component';
import { VisaListComponent} from './document/visa/visa-list/visa-list.component';
import { VisaDetailComponent} from './document/visa/visa-detail/visa-detail.component';
import { HrHomeComponent} from './home/hr-home/hr-home.component';
import { UserHomeComponent} from './home/user-home/user-home.component';
import { HouseListComponent } from './house/house-list/house-list.component';
import { HouseDetailComponent } from './house/house-detail/house-detail.component';
import { HirePageComponent } from './hire-page/hire-page.component';
import { HomedetailComponent } from './home/user-home/homedetail/homedetail.component';
import { OnboardComponent } from './onboard/onboard.component';
import { RedirectGuard } from './routeGuard/redirectGuard';
import { UserEmployeeComponent} from './employee/user-employee/user-employee.component';
import { HrMainComponent } from './home/hr-main/hr-main.component';
import { UservalidationService} from './routeGuard/uservalidation.service';
import { HrvalidationService} from './routeGuard/hrvalidation.service';
import { UserVisaComponent} from './document/visa/user-visa/user-visa.component';
import { CheckOnboardComponent} from './check-onboard/check-onboard.component';
import { DetailResolverService } from './routeGuard/detail-resolver.service';
import { ApplicationResolverService } from './hire-page/application-view/application-resolver.service';
import { OnboardResolverService } from './onboard/onboard-resolver.service';
import { AllEmployeeResolverService } from './onboard/all-employee-resolver.service';
import { UserHouseComponent } from './house/user-house/user-house.component';
import { UserFacilityReportComponent } from './house/user-facility-report/user-facility-report.component';
import { HouseResolverService } from './house/house-resolver.service';
import { HrHomeResolverService } from './home/hr-home/hr-home-resolver.service';
import { SingleApplicationResolverService } from './hire-page/application-view/single-application-resolver.service';
import { WildcardRedirectComponent } from './routeGuard/wildcard-redirect/wildcard-redirect.component';
// import {UserEmployeeComponent} from './employee/user-employee/user-employee.component';
// import {UserVisaComponent} from './document/visa/user-visa/user-visa.component';

const routes: Routes = [
  {
    path: 'onboard', component: OnboardComponent, 
      resolve: {employee: OnboardResolverService,
                application: SingleApplicationResolverService}
  },
  {
    path: 'pendingApplication', component: CheckOnboardComponent,
  },
  {
    path: 'hr', component: HrMainComponent,
    canActivate:[HrvalidationService],
    canActivateChild:[HrvalidationService],
    children: [
      {path: 'home', component: HrHomeComponent,
        resolve: {
          employeeList: HrHomeResolverService
        }
      },
      {path: 'hire', component: HirePageComponent,
        resolve: {tokens: DetailResolverService,
                  applications: ApplicationResolverService,
                  employees: AllEmployeeResolverService}},
      {path: 'house', component: HouseListComponent,
       resolve: {
         houseList: HouseResolverService
       },
        children: [
          {path: 'id/:id', component: HouseDetailComponent}
        ]
      },
      {path: 'employee', component: EmployeeListComponent,
        children: [
          {path: 'id/:id', component: EmployeeProfileComponent}
        ]
      },
      {path: 'visa', component: VisaListComponent,
        children: [
          {path: 'id/:id', component: VisaDetailComponent}
        ]
      },
      {path: 'logout', component: RedirectGuard,
        canActivate: [RedirectGuard],
        data: {
          externalUrl: 'http://localhost:8082/logout'
        }
      }
    ]
  },
  {
    path: 'user', component: UserHomeComponent,
    canActivate:[UservalidationService],
    canActivateChild:[UservalidationService],
    children: [
      {path: 'home', component: HomedetailComponent },
      // {path: 'onboard', component: OnboardComponent, 
      // resolve: {employee: OnboardResolverService,
      //   application: SingleApplicationResolverService} },
      {
        path: 'employee', component: UserEmployeeComponent
      },
      {
        path: 'visa' , component: UserVisaComponent
      },
      {
        path: 'housing', component: UserHouseComponent
      },
      {
        path: 'facility-report', component: UserFacilityReportComponent
      },
      {path: 'test', component: RedirectGuard,
        canActivate: [RedirectGuard],
        data: {
          externalUrl: 'http://localhost:8081/test3'
        }
      },
      {path: 'logout', component: RedirectGuard,
        canActivate: [RedirectGuard],
        data: {
          externalUrl: 'http://localhost:8082/logout'
        }
      },
    ]
  },
  {
    path: '', component:WildcardRedirectComponent, pathMatch: 'full'
  },
  {
    path: '**', component:WildcardRedirectComponent,
  },
];


@NgModule({
  imports: [RouterModule.forRoot(routes,
    {   paramsInheritanceStrategy: 'always',
        useHash: true,
        onSameUrlNavigation: 'reload'
    }, )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
