package lotto.domain.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

	List<Integer> createRandomNumbers() {
		List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

		Collections.sort(numbers);
		return numbers;
	}
}
