package lotto.validation;

import static lotto.constants.Constant.*;
import static lotto.constants.Message.*;

public class SystemValidator {
	public static void validateUserPurchaseAmount(String purchaseAmount) {
		validateIsNumber(purchaseAmount);

		if (!canBuyAtLeastOne(purchaseAmount)) {
			throw new IllegalArgumentException(ERROR_NOT_ENOUGH_PURCHASE_AMOUNT_INPUT);
		}
		if (!isDividedByLottoPrice(purchaseAmount)) {
			throw new IllegalArgumentException(ERROR_DONT_DIVIDED_BY_LOTTO_PRICE);
		}
	}

	public static void validateAllLottoNumberInputElementsIsNumber(String winningLottoNumber) {
		String[] lottoNumbers = winningLottoNumber.split(SPLIT_LOTTO_DELIMITER);
		if (lottoNumbers.length == 0) {
			throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
		}

		for (String lottoNumber : lottoNumbers) {
			validateIsNumber(lottoNumber);
		}
	}

	protected static void validateIsNumber(String input) {
		if (hasNothing(input)) {
			throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
		}
		if (hasZeroValueAtFirstChar(input)) {
			throw new IllegalArgumentException(ERROR_FIRST_CHAR_IS_ZERO);
		}

		validateNumeric(input);
	}

	private static void validateNumeric(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_IS_NOT_NUMERIC_VALUE);
		}
	}

	protected static boolean canBuyAtLeastOne(String purchaseAmount) {
		int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
		return parsedPurchaseAmount >= LOTTO_PRICE;
	}

	protected static boolean hasZeroValueAtFirstChar(String input) {
		return input.charAt(0) == '0';
	}

	protected static boolean isDividedByLottoPrice(String purchaseAmount) {
		int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
		return parsedPurchaseAmount % LOTTO_PRICE == 0;
	}

	protected static boolean hasNothing(String input) {
		return input.isEmpty() || input.isBlank();
	}
}
