package lotto.domain;

import static lotto.domain.LottoTickets.*;
import static lotto.utils.Integer.*;

public class LottoTicketsValidator {
	public static void checkValidityAndThrowException(String purchasingAmount) {
		if (!isConsistValidCharacters(purchasingAmount)) {
			throw new IllegalArgumentException();
		}
		if (!isPositiveNumber(purchasingAmount)) {
			throw new IllegalArgumentException();
		}
		if (!isValidUnit(purchasingAmount)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isConsistValidCharacters(String purchasingAmount) {
		return purchasingAmount.matches("^[0-9]*$");
	}

	private static boolean isPositiveNumber(String purchasingAmount) {
		return toInt(purchasingAmount) >= 0;
	}

	private static boolean isValidUnit(String purchasingAmount) {
		return toInt(purchasingAmount) % MONEY_UNIT == 0;
	}
}
