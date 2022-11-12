package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final static String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static String purchaseLotto() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
		String purchaseAmount = Console.readLine();
		return purchaseAmount;
	}
}
