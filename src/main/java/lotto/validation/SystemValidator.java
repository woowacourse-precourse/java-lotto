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
		for (String lottoNumber : lottoNumbers) {
			validateIsNumber(lottoNumber);
		}
	}

	protected static void validateIsNumber(String purchaseAmount) {
		if (hasNothing(purchaseAmount)) {
			throw new IllegalArgumentException(ERROR_EMPTY_PURCHASE_AMOUNT_INPUT);
		}
		if (!hasOnlyNumeric(purchaseAmount)) {
			throw new IllegalArgumentException(ERROR_NOT_NUMERIC_PURCHASE_AMOUNT_INPUT);
		}
		if (hasZeroValueAtFirstChar(purchaseAmount)) {
			throw new IllegalArgumentException(ERROR_FIRST_ZERO_PURCHASE_AMOUNT_INPUT);
		}
	}

	protected static boolean canBuyAtLeastOne(String purchaseAmount) {
		int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
		return parsedPurchaseAmount >= LOTTO_PRICE;
	}

	protected static boolean hasZeroValueAtFirstChar(String purchaseAmount) {
		return purchaseAmount.charAt(0) == '0';
	}

	protected static boolean isDividedByLottoPrice(String purchaseAmount) {
		int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
		return parsedPurchaseAmount % LOTTO_PRICE == 0;
	}

	protected static boolean hasOnlyNumeric(String purchaseAmount) {
		return purchaseAmount.chars()
				.allMatch(Character::isDigit);
	}

	protected static boolean hasNothing(String purchaseAmount) {
		return purchaseAmount.isEmpty() || purchaseAmount.isBlank();
	}
}
