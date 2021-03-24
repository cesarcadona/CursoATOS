import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Componenteservico1Component } from './componenteservico1.component';

describe('Componenteservico1Component', () => {
  let component: Componenteservico1Component;
  let fixture: ComponentFixture<Componenteservico1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Componenteservico1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Componenteservico1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
