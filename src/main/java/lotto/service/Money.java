package lotto.service;

import static lotto.util.Constants.*;

public class Money {

	public Money() {
	}

	public static void checkMoneyInput(String input) {
		if (!input.matches(ONLY_INTEGER_SERIES)) {
			throw new IllegalArgumentException(ERROR_NUMERIC);
		}

		if (!isUnitOfThousand(input)) {
			throw new IllegalArgumentException(ERROR_UNIT_OF_THOUSAND);
		}
	}

	private static boolean isUnitOfThousand(String input) {
		return Integer.parseInt(input) % LOTTO_PRICE == 0;
	}

	public static int calculateMaximumLottoCount(String input) {
		return Integer.parseInt(input) / LOTTO_PRICE;
	}
}
