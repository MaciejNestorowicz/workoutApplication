import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WorkoutComponent } from './workout/workout.component';
import { ExerciseComponent } from './exercise/exercise.component';
import { WorkoutUnitComponent } from './workout-unit/workout-unit.component';

const routes: Routes = [
{path: '', redirectTo: 'workout-unit', pathMatch: 'full'},
{path: 'workout/workout-unit-id/:id', component: WorkoutComponent},
{path: 'exercise', component: ExerciseComponent},
{path: 'workout-unit', component: WorkoutUnitComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
