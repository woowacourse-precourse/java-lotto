package lotto.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RateOfReturnTest {

	@Test
	void 정상작동() {
		int pay = 1000;
		double answer = (double) (5000 - pay) / pay * 100;

		List<List<Integer>> score = new ArrayList<>();

		score.add(Arrays.asList(3, 5000, 1));
		score.add(Arrays.asList(4, 50000, 0));
		score.add(Arrays.asList(5, 1500000, 0));
		score.add(Arrays.asList(5, 30000000, 0));
		score.add(Arrays.asList(6, 2000000000, 0));

		RateOfReturn rateOfReturn = new RateOfReturn(pay, score);
		assertEquals(answer, rateOfReturn.rateOfReturn);
	}

	@Test
	void 정상작동2() {
		int pay = 1000;
		double answer = (double) (1500000 + 30000000 - pay) / pay * 100;

		List<List<Integer>> score = new ArrayList<>();

		score.add(Arrays.asList(3, 5000, 0));
		score.add(Arrays.asList(4, 50000, 0));
		score.add(Arrays.asList(5, 1500000, 1));
		score.add(Arrays.asList(5, 30000000, 1));
		score.add(Arrays.asList(6, 2000000000, 0));

		RateOfReturn rateOfReturn = new RateOfReturn(pay, score);
		assertEquals(answer, rateOfReturn.rateOfReturn);
	}
}