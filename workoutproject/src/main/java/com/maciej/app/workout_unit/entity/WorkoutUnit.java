package com.maciej.app.workout_unit.entity;

import com.maciej.app.workout.entity.Workout;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workout_unit2")
public class WorkoutUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workoutUnitName;

    @Column(name = "workout_date")
    private LocalDate workoutUnitDate = LocalDate.now();

//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "workout_units",
//            joinColumns = { @JoinColumn(name = "workout_unit_id") },
//            inverseJoinColumns = { @JoinColumn(name = "workout_id") })
    @OneToMany(mappedBy = "workoutUnitId", cascade = CascadeType.ALL)
    private Set<Workout> workouts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkoutUnitName() {
        return workoutUnitName;
    }

    public void setWorkoutUnitName(String workoutUnitName) {
        this.workoutUnitName = workoutUnitName;
    }

    public Set<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<Workout> workouts) {
        this.workouts = workouts;
    }

    public LocalDate getWorkoutUnitDate() {
        return workoutUnitDate;
    }

    public void setWorkoutUnitDate(LocalDate workoutUnitDate) {
        this.workoutUnitDate = workoutUnitDate;
    }

    @Override
    public String toString() {
        return "WorkoutUnit{" +
                "id=" + id +
                ", workoutUnitName='" + workoutUnitName + '\'' +
                ", workoutDate=" + workoutUnitDate +
                ", workouts=" + workouts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutUnit that = (WorkoutUnit) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
