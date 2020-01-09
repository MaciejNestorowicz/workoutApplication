import {Component, OnInit, ViewChild}from '@angular/core';
import {ApiService}from "../api.service";
import {Router, ActivatedRoute, ParamMap}from '@angular/router';
import {switchMap}from 'rxjs/operators';
import {MatTable}from '@angular/material/table';

@Component({
selector: 'app-workout',
templateUrl: './workout.component.html',
styleUrls: ['./workout.component.css']
})
export class WorkoutComponent implements OnInit {

@ViewChild(MatTable,{static:true}) table: MatTable<any>;

workouts = [];
workoutTableColumns = ["sets", "reps", "weight", "exercise_name", "actions"];

constructor(private apiService: ApiService, private router: Router, private route: ActivatedRoute) { }

  workoutUnitId;
  showWorkoutDetails = false;
  showExerciseDetails = false;


  ngOnInit() {

    this.workoutUnitId = this.route.snapshot.params.id;

   this.apiService.getWorkoutByWorkoutUnitId(this.workoutUnitId).subscribe((data: any[])=>{
      console.log(data);
      this.workouts = data;
    })
  }

    clickAddWorkoutButton(){
      this.showWorkoutDetails = true;
    }


  clickAddExerciseButton(){
      this.showExerciseDetails = true;
    }

  onEventFromDetailView(event){
  if(event.event == "added entry"){
        this.workouts.push(event.entry)
        this.table.renderRows();
    }
  }

  clickDeleteButton(element){
    if(confirm("Do you want to delte this Workout?")){
    this.apiService.deleteWorkoutById(element.id).subscribe((data: any[])=>{
    this.apiService.getWorkoutByWorkoutUnitId(element.workoutUnitId).subscribe((data: any[])=>{
    console.log(data);
    this.workouts = data;
    this.table.renderRows();
    })
    })
    } else {
            return;
            }
  }
}
