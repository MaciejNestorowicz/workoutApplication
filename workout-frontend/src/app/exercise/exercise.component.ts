import { Component, OnInit } from '@angular/core';
import {ApiService} from "../api.service";

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css']
})
export class ExerciseComponent implements OnInit {

exercises = [];
exerciseTableColumns = ["name", "type"];

constructor(private apiService: ApiService) { }

  ngOnInit() {
  this.apiService.getExercise().subscribe((data: any[])=>{
    console.log(data);
    this.exercises = data;
  })
  }
}
