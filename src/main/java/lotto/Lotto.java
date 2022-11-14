package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateLength(numbers);
		validateDuplication(numbers);
		this.numbers = numbers;
	}

	// TODO: 추가 기능 구현
	public List<Integer> getWinningNumbers() {
		return numbers;
	}

	public void validateLength(List<Integer> numbers) {
		if (numbers.size() != EnumNumeric.LOTTO_NUMBERS_BOUND.getValue()) {
			throw new IllegalArgumentException(EnumError.OUT_OF_BOUNDS.getValue());
		}
	}

	public void validateDuplication(List<Integer> numbers) {
		List<Integer> DuplicationValidator = new ArrayList<>();

		for (int number : numbers) {
			if (DuplicationValidator.contains(number)) {
				throw new IllegalArgumentException(EnumError.DUPLICATED.getValue());
			}

			DuplicationValidator.add(number);
		}
	}
}
