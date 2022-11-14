package lotto;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		overlap(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(Constant.INPUT_SIZE_ERROR);
		}
	}

	// TODO: 추가 기능 구현

	private void overlap(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException(Constant.NUMBER_OVERLAP_ERROR);
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
