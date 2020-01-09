import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {ApiService}from "../api.service";

@Component({
  selector: 'app-exercise-detail',
  templateUrl: './exercise-detail.component.html',
  styleUrls: ['./exercise-detail.component.css']
})
export class ExerciseDetailComponent implements OnInit {

  editFormExercise;

  @Input() workoutUnitId;

  @Output() eventEmitterExercise = new EventEmitter();

  constructor(private apiService: ApiService, private formBuilder: FormBuilder) {
  this.editFormExercise = this.formBuilder.group({
    name : '',
    type : '',
  })
  }

  ngOnInit() {
  }

  onSubmit(exercise){
      if(confirm("Do you want to add this exercise?")){
      let exerciseBody = {exerciseName : exercise.name,
                        exerciseType : exercise.type}
      this.apiService.addExercise(exerciseBody).subscribe((data: any)=>{
      this.eventEmitterExercise.emit({event:"added entry", entry : data})
      })
    } else{
      return;
    }
  }
}
