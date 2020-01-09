package com.maciej.app;

import com.maciej.app.exercise.ExerciseManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	ExerciseManager exerciseManager;

	@Test
	void testGetExerciseType() {
		Set<String> exerciseTypes = exerciseManager.getExerciseTypes();
		Set<String> types = new HashSet<>();
		types.add("chest");
		types.add("back");
		types.add("legs");
		types.add("shoulders");
		types.add("glutes");

		assertThat(exerciseTypes).isEqualTo(types);
	}


}
