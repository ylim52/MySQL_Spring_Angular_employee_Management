import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckOnboardComponent } from './check-onboard.component';

describe('CheckOnboardComponent', () => {
  let component: CheckOnboardComponent;
  let fixture: ComponentFixture<CheckOnboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckOnboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckOnboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
