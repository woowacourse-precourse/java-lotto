package lotto;

import lotto.ui.ConsoleOutput;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
		ConsoleOutput.PrintIssuedLotto(numbers);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != Rule.LOTTO_NUMBER_DIGITS.getValue()) {
			throw new IllegalArgumentException();
		}

		if (isDuplicateExists(numbers)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isDuplicateExists(List<Integer> numbers) {
		Set<Integer> checkDuplicate = new HashSet<>(numbers);
		checkDuplicate.retainAll(numbers);
		return checkDuplicate.size() != Rule.LOTTO_NUMBER_DIGITS.getValue();
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
