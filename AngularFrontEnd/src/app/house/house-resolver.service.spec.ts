import { TestBed } from '@angular/core/testing';

import { HouseResolverService } from './house-resolver.service';

describe('HouseResolverService', () => {
  let service: HouseResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HouseResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
