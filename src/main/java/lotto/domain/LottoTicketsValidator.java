package lotto.domain;

import static lotto.domain.LottoTickets.*;
import static lotto.utils.Integer.*;

public class LottoTicketsValidator {
	private static final String ERROR = "[ERROR] ";
	public static void checkValidityAndThrowException(String purchasingAmount) {
		if (!isConsistValidCharacters(purchasingAmount)) {
			throw new IllegalArgumentException(ERROR + "올바른 금액을 입력해 주세요.");
		}
		if (!isPositiveNumber(purchasingAmount)) {
			throw new IllegalArgumentException(ERROR + "올바른 금액을 입력해 주세요.");
		}
		if (!isValidUnit(purchasingAmount)) {
			throw new IllegalArgumentException(ERROR + "1000원 단위의 금액이어야 합니다.");
		}
	}

	private static boolean isConsistValidCharacters(String purchasingAmount) {
		return purchasingAmount.matches("^[0-9]+$");
	}

	private static boolean isPositiveNumber(String purchasingAmount) {
		return toInt(purchasingAmount) >= 0;
	}

	private static boolean isValidUnit(String purchasingAmount) {
		return toInt(purchasingAmount) % MONEY_UNIT == 0;
	}
}
