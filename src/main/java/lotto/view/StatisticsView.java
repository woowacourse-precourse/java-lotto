package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.domain.Grade;

public class StatisticsView {
	private static final String WIN_STATICS = "당첨통계\n---";

	public static void getStatisticsView(Map<Grade, Integer> winGames, String earningRate) {
		System.out.println();
		System.out.println(WIN_STATICS);
		getWinGamesView(winGames);
		getEarningRateView(earningRate);
	}

	public static void getWinGamesView(Map<Grade, Integer> winGames) {
		winGames.forEach((grade, count) -> {
			String reward = getReward(grade, count);
			System.out.println(reward);
		});
	}

	private static String getReward(Grade grade, int count) {
		if (grade == Grade.SECOND) {
			return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", grade.getWinningNumberCount(), convertDecimalFormat(
				grade.getCashPrize()), count);
		}
		return String.format("%d개 일치 (%s원) - %d개", grade.getWinningNumberCount(), convertDecimalFormat(
			grade.getCashPrize()), count);
	}

	private static String convertDecimalFormat(int cashPrize) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(cashPrize);
	}

	private static void getEarningRateView(String earningRate) {
		String totalEarningRate = String.format("총 수익률은 %s%%입니다.", earningRate);
		System.out.println(totalEarningRate);
	}
}
