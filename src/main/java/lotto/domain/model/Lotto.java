package lotto.domain.model;

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
			throw new IllegalArgumentException("중복된 수가 있음");
		}
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("크기가 6이 아님");
		}
	}

	public List<Integer> getLotto() {
		return this.numbers;
	}
}
