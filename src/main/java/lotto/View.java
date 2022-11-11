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
	private static final String YIELD_GUIDE_MESSAGE = "총 수익률은 ";
	private static final String YIELD_GUIDE_MESSAGE_END = "입니다.";
	private static final String NOT_MATCH = "미당첨";
	private static final String FIFTH_WINNER = "3개 일치 (5,000원) - ";
	private static final String FOURTH_WINNER = "4개 일치 (50,000원) - ";
	private static final String THIRD_WINNER = "5개 일치 (1,500,000원) - ";
	private static final String SECOND_WINNER = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
	private static final String FIRST_WINNER = "6개 일치 (2,000,000,000원) - ";
	private static final int FIFTH_WINNER_INDEX = 3;
	private static final int FIRST_WINNER_INDEX = 7;

	private static final List<String> winnerPrize = new ArrayList<>(List.of(
		FIFTH_WINNER, FOURTH_WINNER, THIRD_WINNER, SECOND_WINNER, FIRST_WINNER));

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

		for (int index = 0; index < winnerPrize.size(); index++) {
			System.out.println(winnerPrize.get(index) + LottoComparator.prizeCount.get(index) + "개");
		}

	}

	public static void showYield(String yield) {
		System.out.println(YIELD_GUIDE_MESSAGE + yield + "%" + YIELD_GUIDE_MESSAGE_END);
	}

	public static void showMyLottos(int lottoCount, List<Lotto> lottoList) {
		View.showLottoPurchasedGuideMessage(lottoCount);
		View.showLottoNumbers(lottoList);
	}
}
