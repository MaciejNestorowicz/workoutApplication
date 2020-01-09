package com.maciej.app.workout_unit;

import com.maciej.app.workout.WorkoutRepo;
import com.maciej.app.workout.entity.Workout;
import com.maciej.app.workout_unit.entity.WorkoutUnit;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutUnitManager {

    private WorkoutUnitRepo workoutUnitRepo;


    public WorkoutUnitManager(WorkoutUnitRepo workoutUnitRepo) {
        this.workoutUnitRepo = workoutUnitRepo;
    }

    public WorkoutUnit saveWorkoutUnit(WorkoutUnit workoutUnit){
        return workoutUnitRepo.save(workoutUnit);
    }

    public void deleteWorkoutUnit(Long id){
        workoutUnitRepo.deleteById(id);
    }

    public Optional<WorkoutUnit> findById(Long id){
        return workoutUnitRepo.findById(id);
    }

    public Iterable<WorkoutUnit> getWorkoutUnits(){
        return workoutUnitRepo.findAll();
    }
}
