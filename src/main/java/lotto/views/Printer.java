package lotto.views;

import lotto.models.Lotto;

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
		lotteries.forEach(lotto -> System.out.println(lotto.toString()));
	}

	public static void showUserPurchasedLottoCount(int purchaseAmount) {
		System.out.printf(SHOW_USER_PURCHASED_LOTTO_COUNT, purchaseAmount / LOTTO_PRICE);
	}
}
