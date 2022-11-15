package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.domain.constant.ResultConstant.*;
import static lotto.view.constant.InputMessage.*;
import static lotto.view.constant.OutputMessage.*;

import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Result;

public class LottoView {

	public static void displayInputPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
	}

	public static void displayPurchasedLottoAmount(int purchasedLottoCount) {
		System.out.printf(OUTPUT_PURCHASE_AMOUNT, purchasedLottoCount);
	}

	public static void displayPurchasedLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			List<Integer> sortedLottoNumbers = lotto.getLottoNumbers();
			Collections.sort(sortedLottoNumbers);
			System.out.println(lotto.getLottoNumbers());
		}
	}

	public static String getUserInput() {
		return readLine();
	}

	public static void displayInputWinningLotto() {
		System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
	}

	public static void displayInputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
	}

	public static void displayWinningStatistics() {
		System.out.println(OUTPUT_WINNING_STATISTICS);
		System.out.println(OUTPUT_WINNING_STATISTICS_DIVIDER);
		System.out.printf(OUTPUT_WINNING_STATISTICS_FORMAT_5TH, Result.getStatisticsByRank(FIFTH_PLACE));
		System.out.printf(OUTPUT_WINNING_STATISTICS_FORMAT_4TH, Result.getStatisticsByRank(FOURTH_PLACE));
		System.out.printf(OUTPUT_WINNING_STATISTICS_FORMAT_3RD, Result.getStatisticsByRank(THIRD_PLACE));
		System.out.printf(OUTPUT_WINNING_STATISTICS_FORMAT_2ND, Result.getStatisticsByRank(SECOND_PLACE));
		System.out.printf(OUTPUT_WINNING_STATISTICS_FORMAT_1ST, Result.getStatisticsByRank(FIRST_PLACE));
	}

	public static void displayProfitRate() {
		System.out.printf(OUTPUT_PROFIT_RATE, Result.getProfitRate());
	}

}
