package com.maciej.app.exercise;

import com.maciej.app.exercise.entity.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ExerciseRepo extends CrudRepository<Exercise, Long> {

    List<Exercise> findAllByExerciseType(String exerciseType);

    @Query("SELECT e FROM Exercise e WHERE e.exerciseType = 'legs'")
    List<Exercise> findAllLegsExercises();

    @Query("SELECT DISTINCT e.exerciseType FROM Exercise e")
    Set<String> findAllExerciseTypes();

    // named parameters
    @Query("SELECT e FROM Exercise e WHERE e.exerciseType = :category")
    List<Exercise> getAllByCategory(@Param("category") String category);
}
