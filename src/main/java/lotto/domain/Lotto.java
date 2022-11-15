package lotto.domain;

import static lotto.domain.LottoBonus.*;
import static lotto.utils.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final static int LOTTO_SIZE = 6;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private static void validate(List<Integer> numbers) {
		if (!isConsistOfSixNumbers(numbers)) {
			throw new IllegalArgumentException(INPUT_SIX_NUMBER.getMessage());
		}
		if (isDuplicatedNumbers(numbers)) {
			throw new IllegalArgumentException(INPUT_NOT_DUPLICATED.getMessage());
		}
		if (!isValidRange(numbers)) {
			throw new IllegalArgumentException(INPUT_VALID_RANGE.getMessage());
		}
	}

	private static boolean isValidRange(List<Integer> numbers) {
		return numbers.stream().allMatch(n -> n >= MIN_NUMBER && n <= MAX_NUMBER);
	}

	private static boolean isConsistOfSixNumbers(List<Integer> numbers) {
		return numbers.size() == LOTTO_SIZE;
	}

	private static boolean isDuplicatedNumbers(List<Integer> numbers) {
		Set<Integer> set = new HashSet<>(numbers);
		return set.size() != 6;
	}
}
