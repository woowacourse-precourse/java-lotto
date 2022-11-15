package lotto.validator;

import java.util.List;

public class LottoNumberValidator {
	public static void validateNumberCountIsSix(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_WINNING_NUMBERS_LENGTH);
		}
	}

	public static void validateIsInLottoRange(List<Integer> numbers) {
		for (int num : numbers) {
			validateIsInLottoRange(num);
		}
	}

	public static void validateIsInLottoRange(int num) {
		if (!(num >= 1 && num <= 45)) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_OUT_OF_LOTTO_RANGE);
		}
	}

	public static void validateHasNoDuplication(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			int num = numbers.get(i);
			if (numbers.lastIndexOf(num) != i) {
				throw new IllegalArgumentException(ErrorConstants.ERROR_DUPLICATION_LOTTO_NUMBER);
			}
		}
	}

	public static void validateHasNoDuplication(List<Integer> numbers, int bonusNumber) {
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_DUPLICATION_BONUS_NUMBER);
		}
	}
}
