package lotto.domain;

import static lotto.domain.message.ErrorMessageConstants.*;
import static lotto.restrict.RestrictConstants.*;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

    private void validate(List<Integer> numbers) {
		if (numbers.size() != LIMIT_SIZE) {
			throw new IllegalArgumentException(String.format(SIZE_ERROR_MESSAGE_FORMAT, LIMIT_SIZE));
		}
		if (checkRangeNumbers(numbers)) {
			throw new IllegalArgumentException(String.format(RANGE_ERROR_MESSAGE_FORMAT, MIN_NUMBER, MAX_NUMBER));
		}
		if (checkDuplicateNumbers(numbers)) {
			throw new IllegalArgumentException(String.format(DUPLICATION_ERROR_MESSAGE));
		}
	}

	// TODO: 추가 기능 구현
	public List<Integer> getNumbers() {
		return numbers;
	}

	private boolean checkRangeNumbers(List<Integer> numbers) {
		for (int number : numbers) {
			if (number < MIN_NUMBER || MAX_NUMBER < number) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDuplicateNumbers(List<Integer> numbers) {
		List<Integer> duplicateNumbers = new ArrayList<>();

		for (int number : numbers) {
			if (duplicateNumbers.contains(number)) {
				return true;
			}
			duplicateNumbers.add(number);
		}
		return false;
	}
}
