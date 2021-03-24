import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteservicoComponent } from './componenteservico.component';

describe('ComponenteservicoComponent', () => {
  let component: ComponenteservicoComponent;
  let fixture: ComponentFixture<ComponenteservicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteservicoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteservicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
