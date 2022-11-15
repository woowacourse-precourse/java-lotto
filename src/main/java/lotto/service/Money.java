package lotto.service;

import static lotto.util.Constants.*;

import lotto.util.Validator;

public class Money {
	private static int ticketCount;

	public Money() {
	}

	public static void checkMoneyInput(String input) {
		Validator.validateNumber(input);
		Validator.validateUnitOfMoney(input);
	}

	public static int calculateMaximumLottoCount(String input) {
		return ticketCount = Integer.parseInt(input) / LOTTO_PRICE;
	}

	public static int getTicketCount() {
		return ticketCount;
	}
}
