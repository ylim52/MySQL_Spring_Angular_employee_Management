import { TestBed } from '@angular/core/testing';

import { SingleApplicationResolverService } from './single-application-resolver.service';

describe('SingleApplicationResolverService', () => {
  let service: SingleApplicationResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SingleApplicationResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
