package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

	public final static int LOTTO_NUMBER_MIN = 1;
	public final static int LOTTO_NUMBER_MAX = 45;
	public final static int LOTTO_MAX_RANGE = 6;
	public final static String ERROR_DUPLICATION = "[ERROR] 로또 번호가 중복됩니다.";
	public final static String ERROR_SIZE = "[ERROR] 로또 번호가 6개가 아닙니다";
	public final static String ERROR_MISSNUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateNumber(numbers);
		validateDuplication(numbers);
		this.numbers = numbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != LOTTO_MAX_RANGE) {
			throw new IllegalArgumentException(ERROR_SIZE);
		}
	}

	// TODO: 추가 기능 구현
	private void validateDuplication(List<Integer> numbers) {
		boolean duplicated = numbers.stream()
			.distinct()
			.count() != numbers.size();

		if (duplicated) {
			throw new IllegalArgumentException(ERROR_DUPLICATION);
		}
	}

	private void validateNumber(List<Integer> numbers) {
		boolean isMissNumber = numbers.stream()
			.anyMatch(number -> number > LOTTO_NUMBER_MAX || number < LOTTO_NUMBER_MIN);

		if (isMissNumber) {
			throw new IllegalArgumentException(ERROR_MISSNUMBER);
		}
	}

	@Override
	public String toString() {
		return numbers.stream().sorted().map(Object::toString)
			.collect(Collectors.joining(", ", "[", "]"));
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
