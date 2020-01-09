package com.maciej.app.workout;

import com.maciej.app.workout.entity.Workout;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutManager {
    private WorkoutRepo workoutRepo;

    public WorkoutManager(WorkoutRepo workoutRepo) {
        this.workoutRepo = workoutRepo;
    }

    public Workout saveWorkout(Workout workout){
        return workoutRepo.save(workout);
    }

    public void deleteWorkout(Long id){
        workoutRepo.deleteById(id);
    }

    public Optional<Workout> findById(Long id){
        return workoutRepo.findById(id);
    }

    public Iterable<Workout> getWorkouts(){
        return workoutRepo.findAll();
    }

    public Iterable<Workout> getWorkoutsByWorkoutUnitId(Long id){
        return workoutRepo.findWorkoutByWorkoutUnitId(id);
    }
}
