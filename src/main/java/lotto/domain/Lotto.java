package lotto.domain;

import java.util.List;

import lotto.util.Validator;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		Validator.validateSizeOfNumbers(numbers);
		Validator.validateNoDuplication(numbers);
		numbers.forEach(Validator::validateNumberRange);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
