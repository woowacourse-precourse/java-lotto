package utils;

import camp.nextstep.edu.missionutils.Console;

public class InputLottoPurchaseAmount {

	public static int readLottoPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String purchaseAmount = Console.readLine();
		int purchaseAmountResult = validate(purchaseAmount);

		return purchaseAmountResult;
	}

	private static int validate(String purchaseAmount) {
		validateNumeric(purchaseAmount);
		int purchaseAmountResult = Integer.parseInt(purchaseAmount);
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

	private static void validatePurchaseAmountRange(int purchaseAmoutResult) {
		if (purchaseAmoutResult < 1000) {
			throw new IllegalArgumentException("[ERROR] 로또 최소 구입금액은 1000원 입니다.");
		}
	}

	private static void validatePurchaseAmountUnit(int purchaseAmoutResult) {
		if (purchaseAmoutResult % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1000원 단위여야 합니다.");
		}
	}
}