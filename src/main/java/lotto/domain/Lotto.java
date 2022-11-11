package lotto.domain;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validNumbersSize(numbers);
		validRange(numbers);
		validDuplicated(numbers);
	}

	private void validNumbersSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	private void validDuplicated(List<Integer> numbers) {
		//중복되지 않는 숫자
		int count = (int)numbers.stream().filter(n -> numbers.contains(n)).count();
		if (count != 6) {
			throw new IllegalArgumentException();
		}
	}

	private void validRange(List<Integer> numbers) {
		//범위 1부터 45 까지
		int count = (int)numbers.stream().filter(i -> 1 <= i && i <= 45).count();
		if (count != 6) {
			throw new IllegalArgumentException();
		}
	}

}
