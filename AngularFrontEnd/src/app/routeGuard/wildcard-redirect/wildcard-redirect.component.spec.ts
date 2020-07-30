import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WildcardRedirectComponent } from './wildcard-redirect.component';

describe('WildcardRedirectComponent', () => {
  let component: WildcardRedirectComponent;
  let fixture: ComponentFixture<WildcardRedirectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WildcardRedirectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WildcardRedirectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
