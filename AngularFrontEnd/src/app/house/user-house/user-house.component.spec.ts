import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHouseComponent } from './user-house.component';

describe('UserHouseComponent', () => {
  let component: UserHouseComponent;
  let fixture: ComponentFixture<UserHouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
