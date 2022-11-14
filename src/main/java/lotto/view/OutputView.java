package lotto.view;

import static lotto.constant.Constants.*;

import java.util.List;

import lotto.constant.PrizeMoney;

public class OutputView {

	public static void printLotto(List<List<Integer>> lottoGames) {
		for (List<Integer> lottoGame : lottoGames) {
			System.out.println(lottoGame);
		}
	}

	public static void printStatistics(List<Integer> places, int money) {
		int totalPrize = getTotalPrize(places);
		double earningRate = (double)totalPrize / money * 100;

		System.out.println(STATISTICS_START);
		System.out.printf(FIFTH_MESSAGE, places.get(4));
		System.out.printf(FOURTH_MESSAGE, places.get(3));
		System.out.printf(THIRD_MESSAGE, places.get(2));
		System.out.printf(SECOND_MESSAGE, places.get(1));
		System.out.printf(FIRST_MESSAGE, places.get(0));
		System.out.printf(EARNING_MESSAGE, (double)Math.round(earningRate * 10) / 10);
	}

	private static int getTotalPrize(List<Integer> places) {
		return PrizeMoney.FIRST.getPrize() * places.get(0)
			+ PrizeMoney.SECOND.getPrize() * places.get(1)
			+ PrizeMoney.THIRD.getPrize() * places.get(2)
			+ PrizeMoney.FOURTH.getPrize() * places.get(3)
			+ PrizeMoney.FIFTH.getPrize() * places.get(4);
	}
}