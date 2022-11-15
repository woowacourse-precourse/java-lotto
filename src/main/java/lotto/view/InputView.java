package lotto.view;

public class InputView {
	private static final String INPUT_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

	public static void getPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
	}

	public static void getWinningNumber() {
		System.out.println();
		System.out.println(INPUT_WINNING_NUMBER);
	}

	public static void getBonusNumber() {
		System.out.println();
		System.out.println(INPUT_BONUS_NUMBER);
	}
}
