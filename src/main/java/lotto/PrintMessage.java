package lotto;

import static lotto.LottoRank.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrintMessage {
	public void purchasePriceMessage() {
		System.out.println(Constant.PURCHASE_PRICE_MESSAGE_QUESTION);
	}

	public void purchaseMessage(int count) {
		System.out.println(count + Constant.BOUGHT_LOTTO_TICKETS);
	}

	public void bonusInputNumberMessage() {
		System.out.println(Constant.BONUS_NUMBER_MESSAGE_QUESTION);
	}

	public void InputNumberMessage() {
		System.out.println(Constant.NUMBER_MESSAGE_QUESTION);
	}

	public void printResultPrize(Map<Integer, Integer> prize) {
		System.out.println(Constant.WINNING_STATISTICS);
		System.out.println(Constant.WINNING_STATISTICS_DIVISION);
		System.out.printf(Constant.WIN_MESSAGE_FRAME, FIFTH_PLACE.getSameNumber(),
			NumberFormat.getInstance().format(FIFTH_PLACE.getWinnerPrize()), prize.get(FIFTH_PLACE.getWinnerPrize()));
		System.out.printf(Constant.WIN_MESSAGE_FRAME, FOURTH_PLACE.getSameNumber(),
			NumberFormat.getInstance().format(FOURTH_PLACE.getWinnerPrize()), prize.get(FOURTH_PLACE.getWinnerPrize()));
		System.out.printf(Constant.WIN_MESSAGE_FRAME, THIRD_PLACE.getSameNumber(),
			NumberFormat.getInstance().format(THIRD_PLACE.getWinnerPrize()), prize.get(THIRD_PLACE.getWinnerPrize()));
		System.out.printf(Constant.WIN_BONUS_MESSAGE_FRAME, SECOND_PLACE.getSameNumber(),
			NumberFormat.getInstance().format(SECOND_PLACE.getWinnerPrize()), prize.get(SECOND_PLACE.getWinnerPrize()));
		System.out.printf(Constant.WIN_MESSAGE_FRAME, FIRST_PLACE.getSameNumber(),
			NumberFormat.getInstance().format(FIRST_PLACE.getWinnerPrize()), prize.get(FIRST_PLACE.getWinnerPrize()));
	}

	public void printPurchaseLotto(List<List<Integer>> purchaseLotto) {
		for (List<Integer> onePurchaseLotto : purchaseLotto) {
			List<Integer> copyPurchaseLotto = new ArrayList<>();
			copyPurchaseLotto.addAll(onePurchaseLotto);
			Collections.sort(copyPurchaseLotto);
			System.out.println(copyPurchaseLotto);
		}
	}

	public void printTotalPrize(double yield) {
		System.out.println(Constant.PROFIT_RATIO + yield + Constant.UNIT_PERCANT);
	}
}
