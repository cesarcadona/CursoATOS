import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteServicoComponent } from './componente-servico.component';

describe('ComponenteServicoComponent', () => {
  let component: ComponenteServicoComponent;
  let fixture: ComponentFixture<ComponenteServicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteServicoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteServicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
