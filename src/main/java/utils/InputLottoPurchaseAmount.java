package utils;

import camp.nextstep.edu.missionutils.Console;

public class InputLottoPurchaseAmount {

	public static long readLottoPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String purchaseAmount = Console.readLine();
		long purchaseAmountResult = validate(purchaseAmount);

		return purchaseAmountResult;
	}

	private static long validate(String purchaseAmount) {
		validateNumeric(purchaseAmount);
		long purchaseAmountResult = Long.parseLong(purchaseAmount);
		validatePurchaseAmountRange(purchaseAmountResult);
		validatePurchaseAmountUnit(purchaseAmountResult);

		return purchaseAmountResult;
	}

	private static void validateNumeric(String purchaseAmount) {
		String regex = "[+-]?\\d*(\\.\\d+)?";
		if (!purchaseAmount.matches(regex)) {
			throw new IllegalArgumentException("[ERROR] 로또 구입금액은 숫자만 입력해야 합니다.");
		}
	}

	private static void validatePurchaseAmountRange(long purchaseAmoutResult) {
		if (purchaseAmoutResult < 1000) {
			throw new IllegalArgumentException("[ERROR] 로또 최소 구입금액은 1000원 입니다.");
		}
	}

	private static void validatePurchaseAmountUnit(long purchaseAmoutResult) {
		if (purchaseAmoutResult % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1000원 단위여야 합니다.");
		}
	}
}