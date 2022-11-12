package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
	private static final String VALIDATE_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
	private static final String VALIDATE_DUPLICATION_EXCEPTION_MESSAGE = "로또 번호는 중복되면 안됩니다.";

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplication(numbers);
		this.numbers = numbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != ConstValue.LOTTO_NUMBERS) {
			throw new IllegalArgumentException(VALIDATE_SIZE_EXCEPTION_MESSAGE);
		}
	}

	// TODO: 추가 기능 구현
	private void validateDuplication(List<Integer> numbers) {
		if (isDuplicatedNumber(numbers)) {
			throw new IllegalArgumentException(VALIDATE_DUPLICATION_EXCEPTION_MESSAGE);
		}
	}

	private boolean isDuplicatedNumber(List<Integer> numbers) {
		return numbers.size() != numbers.stream()
			.distinct()
			.count();
	}

	public List<Integer> getNumbers() {
		return new ArrayList<>(numbers);
	}
}
