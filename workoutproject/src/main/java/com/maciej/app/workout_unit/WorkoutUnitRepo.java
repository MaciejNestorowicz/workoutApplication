package com.maciej.app.workout_unit;

import com.maciej.app.workout_unit.entity.WorkoutUnit;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutUnitRepo extends CrudRepository<WorkoutUnit, Long> {


}
