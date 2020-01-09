package com.maciej.app.workout.entity;

import com.maciej.app.exercise.entity.Exercise;
import com.maciej.app.workout_unit.entity.WorkoutUnit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workout2")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Exercise exercise;

    private Long sets = 0L;

    private Long reps = 0L;

    private Long weight = 0L;

    @Column(name = "workout_unit2_id")
    private Long workoutUnitId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Long getSets() {
        return sets;
    }

    public void setSets(Long sets) {
        this.sets = sets;
    }

    public Long getReps() {
        return reps;
    }

    public void setReps(Long reps) {
        this.reps = reps;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWorkoutUnitId() {
        return workoutUnitId;
    }

    public void setWorkoutUnitId(Long workoutUnitId) {
        this.workoutUnitId = workoutUnitId;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", exercise=" + exercise +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                ", workoutUnitId=" + workoutUnitId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return Objects.equals(id, workout.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
