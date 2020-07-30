import { TestBed } from '@angular/core/testing';

import { ApplicationResolverService } from './application-resolver.service';

describe('ApplicationResolverService', () => {
  let service: ApplicationResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApplicationResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
