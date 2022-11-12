package lotto.domain;

import static lotto.util.ValidUtil.*;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validNumbersSize(numbers);
		validLottoRange(numbers);
		validDuplicated(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
