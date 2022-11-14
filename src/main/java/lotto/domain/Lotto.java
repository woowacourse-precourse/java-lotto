package lotto.domain;

import static lotto.common.exception.ErrorMessage.*;
import static lotto.domain.constant.LottoConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
	private final List<Integer> numbers;

	public final static Map<Integer, Integer> numberCache = new HashMap<>();

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
}
