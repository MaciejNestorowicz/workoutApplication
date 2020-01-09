import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {ApiService}from "../api.service";

@Component({
  selector: 'app-workout-details',
  templateUrl: './workout-details.component.html',
  styleUrls: ['./workout-details.component.css']
})
export class WorkoutDetailsComponent implements OnInit{

  editForm;
  exerciseTypes = [];
  exercises = [];

  @Input() workoutUnitId;

  @Output() eventEmitter = new EventEmitter();

  constructor(private apiService: ApiService, private formBuilder: FormBuilder) {
  this.editForm = this.formBuilder.group({
    sets : '',
    reps : '',
    weight : '',
    exercise : null
})
}

  ngOnInit() {
    this.apiService.getExerciseTypes().subscribe((data: any)=>{
    this.exerciseTypes = data
  })
  }

  onTypesChanged(event){
    this.apiService
      .getExerciseByTypes(event.value)
      .subscribe((data: String[]) => {
        console.log(data);
        this.exercises = data;
      });
  }

  onSubmit(workout){
      let workoutBody = {sets : workout.sets,
                        reps : workout.reps,
                        weight : workout.weight,
                        exercise : workout.exercise,
                        workoutUnitId : this.workoutUnitId}
      this.apiService.addWorkout(workoutBody).subscribe((data: any)=>{
      this.eventEmitter.emit({event:"added entry", entry : data})
      })
  }
}
