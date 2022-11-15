package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final static String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	private final static String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
	private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

	public static String purchaseLotto() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
		String purchaseAmount = Console.readLine();
		return purchaseAmount;
	}

	public static String lottoNumbers() {
		System.out.println(INPUT_LOTTO_NUMBERS);
		String lottoNumbers = Console.readLine();
		return lottoNumbers;
	}

	public static String bonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		String bonusNumber = Console.readLine();
		return bonusNumber;
	}
}
