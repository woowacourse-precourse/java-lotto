package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateNumberSize(numbers);
		validateDuplicateNumber(numbers);
		validateNumberRange(numbers);
		this.numbers = numbers;
	}

	public int calculateSameNumber(List<Integer> winningNumber) {
		return (int)numbers.stream().filter(winningNumber::contains).count();
	}

	private void validateNumberSize(List<Integer> numbers) {
		if (numbers.size() != LottoError.LOTTO_SIZE) {
			throw new IllegalArgumentException(LottoError.LOTTO_SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplicateNumber(List<Integer> numbers) {
		Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
		if (notDuplicateNumbers.size() != LottoError.LOTTO_SIZE) {
			throw new IllegalArgumentException(LottoError.LOTTO_DUPLICATE_ERROR_MESSAGE);
		}
	}

	private void validateNumberRange(List<Integer> numbers) {
		int rightRangeNumberCount = (int)numbers.stream()
			.filter(num -> LottoError.LOTTO_START_RANGE <= num && num <= LottoError.LOTTO_END_RANGE).count();
		if (rightRangeNumberCount != LottoError.LOTTO_SIZE) {
			throw new IllegalArgumentException(LottoError.LOTTO_RANGE_ERROR_MESSAGE);
		}
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}
}
