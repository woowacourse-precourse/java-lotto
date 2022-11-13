package lotto.system.validator;

import java.util.Collections;
import java.util.List;

public class IntegerListToLottoValidator {

	public static final String INVALID_NUMBER_RANGE_MESSAGE = "생성된 숫자가 로또 숫자의 범위에 맞지 않습니다.";
	public static final String INVALID_LIST_SIZE_MESSAGE = "로또 숫자의 개수와 맞지 않습니다.";
	public static final String DUPLICATING_NUMBER_MESSAGE = "로또 숫자 중 중복되는 숫자가 있습니다.";
	public static final int LOTTO_SIZE = 6;
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	public static void validate(List<Integer> target) {
		try {
			hasLottoSize(target);
			isSortedAsc(target);
			for (Integer number : target) {
				isNumberInValidRange(number);
				hasDuplicatingNumber(number, target);
			}
		} catch (ClassCastException exception) {
			throw new IllegalStateException();
		}
	}

	private static void hasDuplicatingNumber(Integer number, List<Integer> target) {
		if (Collections.frequency(target, number) != 1) {
			throw new IllegalArgumentException(DUPLICATING_NUMBER_MESSAGE);
		}
	}

	private static void isNumberInValidRange(Integer target) {
		if (target < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < target) {
			throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
		}
	}

	private static void isSortedAsc(List<Integer> target) {
		Collections.sort(target);
	}

	private static void hasLottoSize(List<Integer> target) {
		if (target.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(INVALID_LIST_SIZE_MESSAGE);
		}
	}
}
