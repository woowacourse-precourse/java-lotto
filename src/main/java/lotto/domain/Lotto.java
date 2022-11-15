package lotto.domain;

import static lotto.common.exception.ErrorMessage.*;
import static lotto.domain.constant.LottoConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
	public final static Map<Integer, Integer> numberCache = new HashMap<>();
	private final List<Integer> numbers;

	static {
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			numberCache.put(i, i);
		}
	}

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public static Lotto from(List<Integer> numbers) {
		return new Lotto(numbers);
	}

	private void validate(List<Integer> numbers) {
		validateLength(numbers);
		validateLottoNumbers(numbers);
		validateDuplicate(numbers);
	}

	private static void validateLength(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(NOT_VALID_SIZE);
		}
	}

	public static void validateLottoNumbers(List<Integer> numbers) {
		for (int number : numbers) {
			if (!numberCache.containsKey(number)) {
				throw new IllegalArgumentException(NOT_VALID_NUMBER);
			}
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != numbers.size()) {
			throw new IllegalArgumentException(NOT_VALID_LOTTO_DUPLICATE);
		}
	}

	public List<Integer> getLottoNumbers() {
		return numbers;
	}

	public int countMatchesWithWinningLotto(List<Integer> winningLotto, Lotto userLotto) {
		int matchCount = 0;

		for (int number : userLotto.numbers) {
			if (winningLotto.contains(number)) {
				matchCount++;
			}
		}

		return matchCount;
	}

	public boolean isMatchWithBonusNumber(int bonusNumber, Lotto userLotto) {
		return userLotto.numbers.contains(bonusNumber);
	}

}
