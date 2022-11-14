package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		Collections.sort(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throwException(ErrorMessage.NUMBERS_ERROR);
		}

		Set<Integer> duplicateCheck = new HashSet<>();

		for (int number : numbers) {
			if(number < 1 || 45 < number) {
				throwException(ErrorMessage.RANGE_ERROR);
			}

			duplicateCheck.add(number);
		}

		if (duplicateCheck.size() != 6) {
			throwException(ErrorMessage.DUPLICATE_ERROR);
		}
	}

	private void throwException(ErrorMessage errorType) {
		errorType.printErrorMessage();
		throw new IllegalArgumentException();
	}

	public List<Integer> getLotto() {
		return numbers;
	}
}
