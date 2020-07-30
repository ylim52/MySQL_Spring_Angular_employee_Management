import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisaListComponent } from './visa-list.component';

describe('VisaListComponent', () => {
  let component: VisaListComponent;
  let fixture: ComponentFixture<VisaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
