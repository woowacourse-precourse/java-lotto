package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.lottoConstant.Constant;
import lotto.lottoConstant.errorMessage.LottoNumberError;

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
		if (numbers.size() != Constant.LOTTO_SIZE) {
			throw new IllegalArgumentException(LottoNumberError.LOTTO_SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplicateNumber(List<Integer> numbers) {
		Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
		if (notDuplicateNumbers.size() != Constant.LOTTO_SIZE) {
			throw new IllegalArgumentException(LottoNumberError.LOTTO_DUPLICATE_ERROR_MESSAGE);
		}
	}

	private void validateNumberRange(List<Integer> numbers) {
		int rightRangeNumberCount = (int)numbers.stream()
			.filter(num -> Constant.MIN_VALUE <= num && num <= Constant.MAX_VALUE).count();
		if (rightRangeNumberCount != Constant.LOTTO_SIZE) {
			throw new IllegalArgumentException(LottoNumberError.LOTTO_RANGE_ERROR_MESSAGE);
		}
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}
}
