package com.maciej.app.workout_unit;

import com.maciej.app.workout.entity.Workout;
import com.maciej.app.workout_unit.entity.WorkoutUnit;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("workout-unit")
@RestController
public class WorkoutUnitRestController {

    private final WorkoutUnitManager workoutUnitManager;

    public WorkoutUnitRestController(WorkoutUnitManager workoutUnitManager) {
        this.workoutUnitManager = workoutUnitManager;
    }

    @PostMapping
    public WorkoutUnit saveWorkoutUnit(@RequestBody WorkoutUnit workoutUnit){
        return workoutUnitManager.saveWorkoutUnit(workoutUnit);
    }

    @DeleteMapping("{id}")
    public void deleteWorkoutUnit(@PathVariable("id") Long id){
        workoutUnitManager.deleteWorkoutUnit(id);
    }

    @GetMapping
    public Iterable<WorkoutUnit> getWorkoutUnits(){
        return workoutUnitManager.getWorkoutUnits();
    }
}
