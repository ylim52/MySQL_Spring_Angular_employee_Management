import { TestBed } from '@angular/core/testing';

import { HrHomeResolverService } from './hr-home-resolver.service';

describe('HrHomeResolverService', () => {
  let service: HrHomeResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HrHomeResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
