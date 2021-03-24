import { TestBed } from '@angular/core/testing';

import { Servico1Service } from './servico1.service';

describe('Servico1Service', () => {
  let service: Servico1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Servico1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
