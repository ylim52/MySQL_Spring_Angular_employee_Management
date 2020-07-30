import { TestBed } from '@angular/core/testing';

import { AllEmployeeResolverService } from './all-employee-resolver.service';

describe('AllEmployeeResolverService', () => {
  let service: AllEmployeeResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllEmployeeResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
