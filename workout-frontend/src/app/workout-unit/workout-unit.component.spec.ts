import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkoutUnitComponent } from './workout-unit.component';

describe('WorkoutUnitComponent', () => {
  let component: WorkoutUnitComponent;
  let fixture: ComponentFixture<WorkoutUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkoutUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkoutUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
