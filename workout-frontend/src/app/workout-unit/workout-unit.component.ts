import{Component, OnInit, ViewChild}from '@angular/core';
import {ApiService}from "../api.service";
import { Router}from '@angular/router';
import {MatTable}from '@angular/material/table';

@Component({
selector: 'app-workout-unit',
templateUrl: './workout-unit.component.html',
styleUrls: ['./workout-unit.component.css']
})
export class WorkoutUnitComponent implements OnInit {

@ViewChild(MatTable,{static:true}) table: MatTable<any>;

workoutUnits = [];
workoutUnitTableColumns = ["workoutUnitName", "workoutUnitDate","actions"];

constructor(private apiService: ApiService, private router : Router) { }

  ngOnInit() {
  this.apiService.getWorkoutUnit().subscribe((data: any[])=>{
    console.log(data);
    this.workoutUnits = data;
  })
  }

  clickOpenButton(element){
    this.router.navigate(['/workout/workout-unit-id', element.id])
    .catch(() => {
    alert("Something went wrong!")
    });
  }

  clickDeleteButton(element){
    if(confirm("Do you want to delte this Workout Unit?")){
    this.apiService.deleteWorkoutUnitById(element.id).subscribe((data: any[])=>{
    this.apiService.getWorkoutUnit().subscribe((data: any[])=>{
    console.log(data);
    this.workoutUnits = data;
    })
    })
    } else {
            return;
            }

  }

    clickAddButton(){
    let name = prompt("Please enter Workout Unit name");
    if(name == null || name == ""){
      return;
    } else {
      let workoutUnitBody = {workoutUnitName : name}
      this.apiService.addWorkoutUnit(workoutUnitBody).subscribe((data: any)=>{
      this.workoutUnits.push(data)
      this.table.renderRows();
      })
    }
  }
}
