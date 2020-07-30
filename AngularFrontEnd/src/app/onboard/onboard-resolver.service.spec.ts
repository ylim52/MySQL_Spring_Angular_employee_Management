import { TestBed } from '@angular/core/testing';

import { OnboardResolverService } from './onboard-resolver.service';

describe('OnboardResolverService', () => {
  let service: OnboardResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OnboardResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
