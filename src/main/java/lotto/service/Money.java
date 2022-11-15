package lotto.service;

import static lotto.util.Constants.*;

public class Money {
	private static int ticketCount;

	public Money() {
	}

	public static void checkMoneyInput(String input) {
		validateNumber(input);
		validateUnitOfMoney(input);
	}

	private static void validateNumber (String input) {
		if (!input.matches(ONLY_INTEGER_SERIES)) {
			throw new IllegalArgumentException(ERROR_NUMERIC);
		}
	}

	private static void validateUnitOfMoney (String input) {
		if (!isUnitOfThousand(input)) {
			throw new IllegalArgumentException(ERROR_UNIT_OF_THOUSAND);
		}
	}

	private static boolean isUnitOfThousand(String input) {
		return Integer.parseInt(input) % LOTTO_PRICE == 0;
	}

	public static int calculateMaximumLottoCount(String input) {
		return ticketCount = Integer.parseInt(input) / LOTTO_PRICE;
	}

	public static int getTicketCount() {
		return ticketCount;
	}
}
