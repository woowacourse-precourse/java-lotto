package lotto;

import static lotto.Constants.*;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateDuplicate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		if(numbers.stream().distinct().count() != numbers.size()) {
			throw new IllegalArgumentException();
		}
	}
}
