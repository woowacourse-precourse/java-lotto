package lotto;

public class View {

	public static void printInputPurchaseAmount() {
		System.out.println(Message.INPUT_PURCHASE_AMOUNT_MESSAGE);
	}

	public static void printLottoAmount(int lottoAmount) {
		System.out.println(lottoAmount + Message.LOTTO_PURCHASE_MESSAGE);
	}

	public static void printInputWinningLottoNumber() {
		System.out.println(Message.INPUT_WINNING_NUMBER);
	}

	public static void printInputBonusNumber() {
		System.out.println(Message.INPUT_BONUS_NUMBER);
	}

	public static void printPrizeResult() {
		System.out.println(Message.RESULT_OF_LOTTO);
	}
}
