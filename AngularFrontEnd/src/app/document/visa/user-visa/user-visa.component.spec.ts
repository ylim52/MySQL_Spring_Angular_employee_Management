import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserVisaComponent } from './user-visa.component';

describe('UserVisaComponent', () => {
  let component: UserVisaComponent;
  let fixture: ComponentFixture<UserVisaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserVisaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserVisaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
