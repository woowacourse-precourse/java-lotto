package lotto.service;

import java.util.List;

import lotto.util.Validator;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		Validator.validate(numbers);
		Validator.validateDuplicate(numbers);
		this.numbers = numbers;
	}

	public boolean contains(Integer integer) {
		return numbers.contains(integer);
	}

	public List<Integer> getLotto() {
		return numbers;
	}

	public int size() {
		return numbers.size();
	}

	public int get(int i) {
		return numbers.get(i);
	}
}
