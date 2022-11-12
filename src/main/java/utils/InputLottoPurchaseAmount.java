package utils;

import camp.nextstep.edu.missionutils.Console;

public class InputLottoPurchaseAmount {

	public static int readLottoPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String purchaseAmount = Console.readLine();

		validateNumeric(purchaseAmount);

		int purchaseAmountResult = Integer.parseInt(purchaseAmount);
		return purchaseAmountResult;
	}

	public static void validateNumeric(String purchaseAmount) {
		String regex = "[+-]?\\d*(\\.\\d+)?";
		if (!purchaseAmount.matches(regex)) {
			throw new IllegalArgumentException("[ERROR] 로또 구입금액은 숫자만 입력해야 합니다.");
		}
	}
}