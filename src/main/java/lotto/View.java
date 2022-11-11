package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;

public class View {
	private static final String PURCHASE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String LOTTO_PURCHASED_GUIDE_MESSAGE = "개를 구매했습니다.";
	private static final String WINNING_NUMBER_INPUT_GUIDE_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_INPUT_GUIDE_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static final String LINES = "---";
	private static final String WINNING_MESSAGE_GUIDE_MESSAGE = "당첨 통계";
	private static final String YIELD_GUIDE_MESSAGE_END="입니다.";
	private static final String YIELD_GUIDE_MESSAGE = "총 수익률은 ";
	private static List<String> winnerPrize;

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

	public static void initWinnerPrize(){
		winnerPrize = new ArrayList<>();

		winnerPrize.add("0개 일치 (미당첨)");
		winnerPrize.add("1개 일치 (미당첨) - ");
		winnerPrize.add("2개 일치 (미당첨) - ");
		winnerPrize.add("3개 일치 (5,000원) - ");
		winnerPrize.add("4개 일치 (50,000원) - ");
		winnerPrize.add("5개 일치 (1,500,000원) - ");
		winnerPrize.add("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
		winnerPrize.add("6개 일치 (2,000,000,000원) - ");
	}

	public static void showWinnings() {
		System.out.println(WINNING_MESSAGE_GUIDE_MESSAGE + "\n" + LINES);

		initWinnerPrize();


		for (int i = 3; i <= 7; i++) {
			System.out.println(winnerPrize.get(i) + MakeWinner.winnerResult[i] + "개");

			/*
			 * count 3, i =3 (5등)
			 * count 4, i =4 (4등)
			 * count 5, i=5 (3등)
			 * count 6, i=6 (2등)
			 * count 7, i=7 (1등)
			 * */
		}

	}

	public static void showYield(String yield) {
		System.out.println(YIELD_GUIDE_MESSAGE+yield+"%"+YIELD_GUIDE_MESSAGE_END);
	}
}
