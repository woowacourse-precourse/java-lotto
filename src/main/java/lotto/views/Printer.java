package lotto.views;

import lotto.models.Lotto;
import lotto.models.LottoResult;
import lotto.models.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static lotto.constants.Constant.*;
import static lotto.constants.Message.*;

public class Printer {
	public static void showAskEnterThePurchaseAmountMessage() {
		System.out.println(ASK_ENTER_THE_PURCHASE_AMOUNT);
	}

	public static void showAskEnterTheWinningLottoNumberMessage() {
		System.out.println(ASK_ENTER_THE_WINNING_LOTTO_NUMBER);
	}

	public static void showAskEnterTheWinningLottoBonusNumberMessage() {
		System.out.println(ASK_ENTER_THE_WINNING_LOTTO_BONUS_NUMBER);
	}

	public static void showUserLottoNumbers(List<Lotto> lotteries) {
		lotteries.forEach(lotto -> {
			List<Integer> sortedLottoNumber = new ArrayList<>(lotto.getLottoNumber());
			Collections.sort(sortedLottoNumber);
			System.out.println(sortedLottoNumber);
		});
	}

	public static void showUserPurchasedLottoCount(int purchaseAmount) {
		System.out.printf(SHOW_USER_PURCHASED_LOTTO_COUNT, purchaseAmount / LOTTO_PRICE);
	}

	public static void showLotteriesResult(LottoResult lottoResult) {
		System.out.println(RESULT_TITLE_MESSAGE);
		Arrays.stream(Rank.values())
				.filter(rank -> !rank.isOutOfRank())
				.forEach(rank -> printLottoRankCountResult(lottoResult, rank));
	}

	private static void printLottoRankCountResult(LottoResult lottoResult, Rank rank) {
		System.out.printf(RESULT_LOTTO_MESSAGES.get(rank), lottoResult.getRankCount(rank));
	}

	public static void showEarningRate(double earningRate) {
		System.out.printf(RESULT_EARNING_RATE, earningRate);
	}
}
