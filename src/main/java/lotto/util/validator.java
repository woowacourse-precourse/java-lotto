package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class validator {
	public static void validateWinningNumber(ArrayList<Integer> integers) {
		for (int i = 0; integers.size() > i; i++) {
			if (integers.get(i) < 1 || integers.get(i) > 45) {
				throw new IllegalArgumentException(String.valueOf(errorMessage.ONLY_INPUT_BETWEEN_1_45));
			}
		}
		Set<Integer> hashIntegers = new HashSet<>(integers);
		if (integers.size() != hashIntegers.size()) {
			throw new IllegalArgumentException(String.valueOf(errorMessage.DUPLICATED_NUMBER));
		}
		if (integers.size() != 6) {
			throw new IllegalArgumentException(String.valueOf(errorMessage.ONLY_INPUT_SIX_NUMBERS));
		}
	}
	public static void validateBonusNumber(ArrayList<Integer> winningNumber, int bonusNumber) {
		if (bonusNumber > 45 || bonusNumber < 1) {
			throw new IllegalArgumentException(String.valueOf(errorMessage.ONLY_INPUT_BETWEEN_1_45));
		}
		for (int i = 0; winningNumber.size() > i; i++) {
			if (winningNumber.get(i) == bonusNumber) {
				throw new IllegalArgumentException(String.valueOf(errorMessage.DUPLICATE_BONUS_NUMBER));
			}
		}

	}
	public static void validateBudget(int budget) {
		if (budget < 1000) {
			throw new IllegalArgumentException(String.valueOf(errorMessage.ONLY_INPUT_THOUSAND_UNIT));
		}
		if (budget % 1000 != 0) {
			throw new IllegalArgumentException(String.valueOf(errorMessage.ONLY_INPUT_THOUSAND_UNIT));
		}
	}
}
