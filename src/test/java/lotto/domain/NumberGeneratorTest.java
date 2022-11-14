package lotto.domain;

import lotto.domain.model.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

	@Test
	void 중복_수_확인(){
		Set<Integer> numberSet = new HashSet<>();
		NumberGenerator numberGenerator = new NumberGenerator();
		List<Integer> numberList = numberGenerator.createRandomNumbers();
//		List<Integer> numberList = Arrays.asList(1,2,3);
		for (int number : numberList)
			numberSet.add(number);
		boolean equals = numberSet.size() == numberList.size();
		assertEquals(equals, true);

	}
}