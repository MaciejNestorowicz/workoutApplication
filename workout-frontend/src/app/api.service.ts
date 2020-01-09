import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import {throwError} from 'rxjs';
import {retry, catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

private SERVER_URL = "http://localhost:8081";

  constructor(private httpClient: HttpClient) { }

  public getWorkout(){
    return this.httpClient.get(this.SERVER_URL + "/workout")
  }

  public getExercise(){
    return this.httpClient.get(this.SERVER_URL + "/exercise")
  }

  public getExerciseTypes(){
    return this.httpClient.get(this.SERVER_URL + "/exercise/exercise-types")
  }

  public getExerciseByTypes(type){
    return this.httpClient.get(this.SERVER_URL + "/exercise/exercise-types/" + type)
  }

  public getWorkoutUnit(){
    return this.httpClient.get(this.SERVER_URL + "/workout-unit")
  }

  public getWorkoutByWorkoutUnitId(workoutUnitId: number){
    return this.httpClient.get(this.SERVER_URL + "/workout/workout-unit-id/" + workoutUnitId)
  }

  public deleteWorkoutUnitById(workoutUnitId: number){
    return this.httpClient.delete(this.SERVER_URL + "/workout-unit/" + workoutUnitId)
    .pipe(
      catchError((error) => {return throwError(error.message)})
    )
  }

  public addWorkoutUnit(workoutUnit){
    return this.httpClient.post(this.SERVER_URL + "/workout-unit/", workoutUnit)
  }

  public deleteWorkoutById(workoutId: number){
    return this.httpClient.delete(this.SERVER_URL + "/workout/" + workoutId)
    .pipe(
      catchError((error) => {return throwError(error.message)})
  )
  }

  public addWorkout(workout){
    return this.httpClient.post(this.SERVER_URL + "/workout/", workout)
  }

  public addExercise(exercise){
  return this.httpClient.post(this.SERVER_URL + "/exercise/", exercise)
  }
}
