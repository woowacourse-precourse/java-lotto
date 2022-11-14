package lotto.domain.util;

import java.util.List;

public class Validator {

	public static void validateInputNotEmpty(String input){
		if (ValidationConfig.isInputEmpty(input)){
			ExceptionHandler.handlePlayer(ValidationException.EMPTY);
		}
	}

	public static void validateAmount(String amountInput) {
		if (ValidationConfig.isNotANumber(amountInput)) {
			ExceptionHandler.handlePlayer(ValidationException.AMOUNT_NOT_A_NUMBER);
		}

		if (ValidationConfig.isLessThanMinimumAmount(amountInput)) {
			ExceptionHandler.handlePlayer(ValidationException.AMOUNT_LESS_THAN_1000);
		}

		if (!ValidationConfig.isAssignedCurrencyUnit(amountInput)) {
			ExceptionHandler.handlePlayer(ValidationException.AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT);
		}
	}

	public static void validateWinningNumber(String winningNumberInput) {
		if (!ValidationConfig.isWinningNumberCorrectlyFormatted(winningNumberInput)) {
			ExceptionHandler.handlePlayer(ValidationException.WINNING_NUMBER_NOT_CORRECTLY_FORMATTED);
		}

		if (!ValidationConfig.isWinningNumberCountCorrectlyProvided(winningNumberInput)) {
			ExceptionHandler.handlePlayer(ValidationException.WINNING_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (!ValidationConfig.isWinningNumberCorrectlyRanged(winningNumberInput)) {
			ExceptionHandler.handlePlayer(ValidationException.WINNING_NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if (ValidationConfig.isWinningNumberDuplicateExists(winningNumberInput)) {
			ExceptionHandler.handlePlayer(ValidationException.WINNING_NUMBER_DUPLICATED);
		}
	}

	public static void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumber) {
		if (!ValidationConfig.isBonusNumberCountCorrectlyProvided(bonusNumberInput)) {
			ExceptionHandler.handlePlayer(ValidationException.BONUS_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (ValidationConfig.isBonusNumberDuplicateExists(bonusNumberInput, winningNumber)) {
			ExceptionHandler.handlePlayer(ValidationException.BONUS_NUMBER_DUPLICATED);
		}

		if (!ValidationConfig.isBonusNumberCorrectlyRanged(bonusNumberInput)) {
			ExceptionHandler.handlePlayer(ValidationException.BONUS_NUMBER_NOT_IN_BETWEEN_1_45);
		}
	}

	public static void validateLottoNumber(List<Integer> numbers) {
		if (numbers.size() != Rule.LOTTO_NUMBER_DIGITS.getValue()) {
			ExceptionHandler.handleLottoMachine(ValidationException.LOTTO_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (ValidationConfig.isLottoNumberDuplicateExists(numbers)) {
			ExceptionHandler.handleLottoMachine(ValidationException.LOTTO_NUMBER_DUPLICATED);
		}
	}
}
