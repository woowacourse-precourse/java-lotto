package lotto.service;

import static lotto.util.Constants.*;

import java.util.List;

public class BonusNumber {
	public static void checkBonusNumber(String input) {
		if (!input.matches(ONLY_INTEGER_SERIES)) {
			throw new IllegalArgumentException(ERROR_NUMERIC);
		}
		if (input.equals("0")) {
			throw new IllegalArgumentException(ERROR_ZERO);
		}
		if (Integer.parseInt(input) > MAX_NUMBER) {
			throw new IllegalArgumentException(ERROR_MAX_NUMBER);
		}
	}

	public static void checkDuplicateBonusNumber(String input, List<Integer> winningNumber) {
		if (winningNumber.contains(Integer.parseInt(input))) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_WITH_WINNINGNUM);
		}
	}
}
