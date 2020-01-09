package com.maciej.app.exercise;

import com.maciej.app.exercise.entity.Exercise;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseManager {

    private ExerciseRepo exerciseRepo;

    public ExerciseManager(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public void saveExercise(Exercise exercise){
        exerciseRepo.save(exercise);
    }

    public void deleteExerciseById(Long id){
        exerciseRepo.deleteById(id);
    }

    public Optional<Exercise> findById(Long id){
        return exerciseRepo.findById(id);
    }

    public Iterable<Exercise> getExercises(){
        return exerciseRepo.findAll();
    }

    public Set<String> getExerciseTypes(){
        return exerciseRepo.findAllExerciseTypes();
    }

    public List<Exercise> getByExerciseType(String exerciseType){
        return exerciseRepo.getAllByCategory(exerciseType);
    }
}
