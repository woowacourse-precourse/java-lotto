package lotto.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
	@Test
	void 정상작동_테스트(){
		NumberGenerator numberGenerator = new NumberGenerator();
		List<Integer> randomNumbers = numberGenerator.createRandomNumbers();

		HashSet<Integer> numberSet = new HashSet<>(randomNumbers);
		assertEquals(numberSet.size(), randomNumbers.size());
	}
}