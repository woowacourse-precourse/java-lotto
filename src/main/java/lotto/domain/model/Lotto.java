package lotto.domain.model;

import lotto.domain.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateOverlap(numbers);
		this.numbers = numbers;
	}

	private void validateOverlap(List<Integer> numbers) {
		HashSet<Integer> numberSet = new HashSet<>(numbers);

		if (numberSet.size() != numbers.size()) {
			new ExceptionHandler(ErrorMessage.ERROR_OVERLAP).tryCatch(ErrorMessage.ERROR_OVERLAP);
		}
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			new ExceptionHandler(ErrorMessage.ERROR_WRONG_SIZE).tryCatch(ErrorMessage.ERROR_WRONG_SIZE);
		}
	}

	public List<Integer> getLotto() {
		return this.numbers;
	}
}
