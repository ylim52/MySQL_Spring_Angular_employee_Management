import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFacilityReportComponent } from './user-facility-report.component';

describe('UserFacilityReportComponent', () => {
  let component: UserFacilityReportComponent;
  let fixture: ComponentFixture<UserFacilityReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFacilityReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFacilityReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
