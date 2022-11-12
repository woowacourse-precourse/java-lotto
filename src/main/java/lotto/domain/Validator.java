package lotto.domain;

import static lotto.ui.ConsoleOutput.*;

public class Validator {

	public void validateAmount(String amountInput) {
		if (ValidationConfig.isNotANumber(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_A_NUMBER);
		}

		if (ValidationConfig.isLessThan1000(amountInput)) {
			PrintErrorMessage(AMOUNT_LESS_THAN_1000);
		}

		if (!ValidationConfig.isAssignedCurrencyUnit(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT);
		}
	}


}
