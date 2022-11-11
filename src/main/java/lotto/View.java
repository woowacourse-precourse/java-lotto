package lotto;

import java.util.List;

import lotto.domain.Lotto;

public class View {
	private static final String PURCHASE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
	private static String LOTTO_PURCHASED_GUIDE_MESSAGE = "개를 구매했습니다.";
	private static String WINNING_NUMBER_INPUT_GUIDE_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static String BONUS_NUMBER_INPUT_GUIDE_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static String LINES = "---";
	private static String WINNING_MESSAGE_GUIDE_MESSAGE = "당첨 통계";

	public static void showPurchaseInputGuideMessage() {
		System.out.println(PURCHASE_INPUT_GUIDE_MESSAGE);
	}

	public static void showLottoPurchasedGuideMessage(int lottoCount) {
		System.out.println("\n" + lottoCount + LOTTO_PURCHASED_GUIDE_MESSAGE);
	}

	public static void showLottoNumbers(List<Lotto> lottoList) {

		for (Lotto lotto : lottoList) {
			System.out.println(lotto.getNumbers());
		}

	}

	public static void showWinningNumberInputGuideMessage() {
		System.out.println("\n" + WINNING_NUMBER_INPUT_GUIDE_MESSAGE);
	}

	public static void showBonusNumberInputGuideMessage() {
		System.out.println("\n" + BONUS_NUMBER_INPUT_GUIDE_MESSAGE);
	}

	public static void showWinnings() {
		System.out.println(WINNING_MESSAGE_GUIDE_MESSAGE + "\n" + LINES);
	}

	public static void showYield() {

	}
}
