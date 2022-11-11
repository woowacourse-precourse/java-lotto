package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final int LOTTO_LENGTH = 6;
	private final int NUMBER_MIN_VALUE = 1;
	private final int NUMBER_MAX_VALUE = 45;
	private final String INVALID_NUMBER_SIZE = "[ERROR] 로또 숫자는 6개여야 합니다.";
	private final String INVALID_OVERLAP = "[ERROR] 로또 숫자중 중복된 숫자는 불가능합니다.";
	private final String INVALID_NUMBER_BOUNDARY = "[ERROR] 로또의 숫자가 제한된 숫자범위(1~45)를 벗어납니다.";
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateNumbersSize(numbers);
		validateNumbersOverlap(numbers);
		validateNumbersBoundary(numbers);
		this.numbers = numbers;
	}

	private void validateNumbersSize(List<Integer> numbers) {
		if (numbers.size() != LOTTO_LENGTH) {
			throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
		}
	}

	private void validateNumbersOverlap(List<Integer> numbers) {
		Set<Integer> overlapTester = new HashSet<>(numbers);
		if (overlapTester.size() != numbers.size()) {
			throw new IllegalArgumentException(INVALID_OVERLAP);
		}
	}

	private void validateNumbersBoundary(List<Integer> numbers) {
		numbers.stream()
			.forEach(number -> validateNumberBoundary(number));
	}

	private void validateNumberBoundary(int number) {
		if (number < NUMBER_MIN_VALUE || number > NUMBER_MAX_VALUE) {
			throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARY);
		}
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
