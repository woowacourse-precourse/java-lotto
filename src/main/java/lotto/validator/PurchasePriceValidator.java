package lotto.validator;

import static lotto.validator.CommonValidator.validateIsNumber;
public class PurchasePriceValidator {
	public static void validatePurchasePrice(String input) {
		validateIsNumber(input);
		validateIsMultipleOfThousand(Integer.parseInt(input));
	}

	private static void validateIsMultipleOfThousand(int num) {
		if (num % 1000 != 0) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_NOT_MULTIPLE_OF_THOUSAND);
		}
	}
}
