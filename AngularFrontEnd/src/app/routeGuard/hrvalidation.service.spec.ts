import { TestBed } from '@angular/core/testing';

import { HrvalidationService } from './hrvalidation.service';

describe('HrvalidationService', () => {
  let service: HrvalidationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HrvalidationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
