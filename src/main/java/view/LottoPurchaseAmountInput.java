package view;

import static view.LottoPurchaseAmountInputConstants.*;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchaseAmountInput {
	
	public long readLottoPurchaseAmount() {
		System.out.println(INPUT_TEXT_PURCHASE_AMOUNT);
		String purchaseAmount = Console.readLine();
		long purchaseAmountResult = validate(purchaseAmount);
		
		return purchaseAmountResult;
	}

	private long validate(String purchaseAmount) {
		validateNumeric(purchaseAmount);
		long purchaseAmountResult = Long.parseLong(purchaseAmount);
		validateMinimumPurchaseAmount(purchaseAmountResult);
		validateMaximumPurchaseAmount(purchaseAmountResult);
		validatePurchaseAmountUnit(purchaseAmountResult);

		return purchaseAmountResult;
	}

	private void validateNumeric(String purchaseAmount) {
		String regex = ALL_CHARACTERS_EXCEPT_NUMBERS;
		if (!purchaseAmount.matches(regex)) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_NON_NUMERIC);
		}
	}

	private void validateMinimumPurchaseAmount(long purchaseAmountResult) {
		if (purchaseAmountResult < PURCHASE_AMOUNT_MINIMUM) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_LESS_THAN_MINIMUM);
		}
	}

	private void validateMaximumPurchaseAmount(long purchaseAmountResult) {
		if (purchaseAmountResult > PURCHASE_AMOUNT_MAXIMUM) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_MORE_THAN_MAXIMUM);
		}
	}

	private void validatePurchaseAmountUnit(long purchaseAmountResult) {
		if (purchaseAmountResult % PURCHASE_AMOUNT_UNIT != 0) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_INVALID_UNIT);
		}
	}
}