import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubdetailComponent } from './subdetail.component';

describe('SubdetailComponent', () => {
  let component: SubdetailComponent;
  let fixture: ComponentFixture<SubdetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubdetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
