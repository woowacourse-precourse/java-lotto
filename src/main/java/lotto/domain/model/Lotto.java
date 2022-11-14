package lotto.domain.model;

import lotto.domain.ui.Printer;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			new Printer().printMessage(Message.ERROR);
			throw new IllegalArgumentException();
		}
	}

	List<Integer> getLotto() {
		return this.numbers;
	}
}
