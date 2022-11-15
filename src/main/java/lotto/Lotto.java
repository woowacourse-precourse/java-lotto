package lotto;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (numbers.get(i) >= numbers.get(i + 1)) {
				throw new IllegalArgumentException();
			}
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
