package lotto.domain;

import lotto.ui.ConsoleInput;

import static java.lang.Integer.*;
import static lotto.ui.ConsoleOutput.*;

public class Player {
	public long receiveTotalAmount() {
		PrintRequestMessage();
		String amountInput = ConsoleInput.readLine();
		validateAmount(amountInput);
		return (long) valueOf(amountInput);
	}

	private void validateAmount(String amountInput) {
		if (amountInput.isEmpty()) {
			PrintErrorMessage(AMOUNT_EMPTY);
		}

		if (Validation.isNotANumber(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_A_NUMBER);
		}

		if (Validation.isLessThan1000(amountInput)) {
			PrintErrorMessage(AMOUNT_LESS_THAN_1000);
		}

		if (!Validation.isAssignedCurrencyUnit(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT);
		}
	}

}
