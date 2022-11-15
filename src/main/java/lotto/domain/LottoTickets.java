package lotto.domain;

import static lotto.utils.ErrorMessage.*;
import static lotto.utils.TypeConversion.*;

import java.util.ArrayList;
import java.util.List;

import lotto.controller.LottoTicketNumberGenerator;

public class LottoTickets {
	public final static int MONEY_UNIT = 1000;
	private List<LottoTicket> lottoTickets = new ArrayList<>();

	public LottoTickets(String purchasingAmount) {
		checkValidityAndThrowException(purchasingAmount);
		purchaseLottoTickets(toInt(purchasingAmount));
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

	private void purchaseLottoTickets(int purchasingAmount) {
		while (purchasingAmount != 0) {
			lottoTickets.add(new LottoTicket(LottoTicketNumberGenerator.generate()));
			purchasingAmount -= MONEY_UNIT;
		}
	}

	public static void checkValidityAndThrowException(String purchasingAmount) {
		if (!isConsistValidCharacters(purchasingAmount)) {
			throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
		}
		if (!isPositiveNumber(purchasingAmount)) {
			throw new IllegalArgumentException(INPUT_VALID_MONEY.getMessage());
		}
		if (!isValidUnit(purchasingAmount)) {
			throw new IllegalArgumentException(INPUT_VALID_UNIT.getMessage());
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
