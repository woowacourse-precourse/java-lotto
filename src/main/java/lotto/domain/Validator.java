package lotto.domain;

import java.util.List;

import static lotto.ui.ConsoleOutput.*;

public class Validator {

	public void validateAmount(String amountInput) {
		if (ValidationConfig.isNotANumber(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_A_NUMBER);
		}

		if (ValidationConfig.isLessThanMinimumAmount(amountInput)) {
			PrintErrorMessage(AMOUNT_LESS_THAN_1000);
		}

		if (!ValidationConfig.isAssignedCurrencyUnit(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT);
		}
	}

	public void validateLottoNumber(String winningNumberInput) {
		if (!ValidationConfig.isLottoNumberCorrectlyFormatted(winningNumberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_CORRECTLY_FORMATTED);
		}

		if (!ValidationConfig.isLottoNumberCountCorrectlyProvided(winningNumberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (!ValidationConfig.isLottoNumberCorrectlyRanged(winningNumberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if (ValidationConfig.isLottoNumberDuplicateExists(winningNumberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_DUPLICATED);
		}
	}

	public void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumber) {
		if (!ValidationConfig.isBonusNumberCorrectlyRanged(bonusNumberInput)) {
			PrintErrorMessage(BONUS_NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if (!ValidationConfig.isBonusNumberCountCorrectlyProvided(bonusNumberInput)) {
			PrintErrorMessage(BONUS_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (ValidationConfig.isBonusNumberDuplicateExists(bonusNumberInput, winningNumber)) {
			PrintErrorMessage(BONUS_NUMBER_DUPLICATED);
		}
	}
}
