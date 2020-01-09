package com.maciej.app.workout;

import com.maciej.app.exercise.entity.Exercise;
import com.maciej.app.workout.entity.Workout;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkoutRepo extends CrudRepository<Workout, Long> {

    @Query("SELECT w FROM Workout w WHERE w.workoutUnitId = :id")
    List<Workout> findWorkoutByWorkoutUnitId(@Param("id") Long id);
}
