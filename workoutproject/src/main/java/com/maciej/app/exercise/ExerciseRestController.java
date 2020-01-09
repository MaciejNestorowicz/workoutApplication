package com.maciej.app.exercise;

import com.maciej.app.exercise.entity.Exercise;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RequestMapping("/exercise")
@RestController
public class ExerciseRestController {

    private final ExerciseManager exerciseManager;

    public ExerciseRestController(ExerciseManager exerciseManager) {
        this.exerciseManager = exerciseManager;
    }

    @PostMapping
    public void saveExercise(@RequestBody Exercise exercise){
        exerciseManager.saveExercise(exercise);
    }

    @DeleteMapping("{id}")
    public void deleteExerciseById(@PathVariable("id") Long id){
        exerciseManager.deleteExerciseById(id);
    }

    @GetMapping
    public Iterable<Exercise> getExercises(){
        return exerciseManager.getExercises();
    }

    @GetMapping("{id}")
    public Optional<Exercise> getExerciseById(@PathVariable("id") Long id){
        return exerciseManager.findById(id);
    }

    @GetMapping("exercise-types")
    public Set<String> getExerciseTypes(){
        return exerciseManager.getExerciseTypes();
    }

    @GetMapping("exercise-types/{type}")
    public List<Exercise> getExercisesByCategory(@PathVariable("type") String type){
        return exerciseManager.getByExerciseType(type);
    }




}
