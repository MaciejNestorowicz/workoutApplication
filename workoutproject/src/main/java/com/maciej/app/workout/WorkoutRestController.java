package com.maciej.app.workout;

import com.maciej.app.workout.entity.Workout;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/workout")
@RestController
public class WorkoutRestController {

    private final WorkoutManager workoutManager;

    @PostMapping
    public Workout saveWorkout(@RequestBody Workout workout){
        return workoutManager.saveWorkout(workout);
    }

    public WorkoutRestController(WorkoutManager workoutManager) {
        this.workoutManager = workoutManager;
    }

    @DeleteMapping("{id}")
    public void deleteWorkout(@PathVariable("id") Long id){
        workoutManager.deleteWorkout(id);
    }

    @GetMapping
    public Iterable<Workout> getWorkouts(){
        return workoutManager.getWorkouts();
    }

    @GetMapping("/workout-unit-id/{id}")
    public Iterable<Workout> getWorkoutsByWorkoutUnitId(@PathVariable("id") Long id){
        return workoutManager.getWorkoutsByWorkoutUnitId(id);
    }
}
