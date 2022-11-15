package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.util.errorMessage;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(String.valueOf(errorMessage.ONLY_INPUT_SIX_NUMBERS));
		}
		Set<Integer> hashNumber = new HashSet<>(numbers);
		if (hashNumber.size() != numbers.size()) {
			throw new IllegalArgumentException(String.valueOf(errorMessage.DUPLICATED_NUMBER));
		}
	}
	// TODO: 추가 기능 구현
}
