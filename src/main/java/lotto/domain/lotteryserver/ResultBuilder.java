package lotto.domain.lotteryserver;

import java.text.DecimalFormat;

public class ResultBuilder {
	public static String getFirstAnnouncement() {
		return Messages.getFirstAnnouncement();
	}

	public static String getMatchedNumber(Rank rank) {
		if (rank == Rank.SECOND_RANK) {
			return rank.getMatchedCount() + Messages.getBonusWinner();
		}

		return rank.getMatchedCount() + Messages.getNormalWinner();
	}

	public static String getPrizeMoney(Rank rank) {
		String formattedMoney = ResultBuilder.decimalFormatter(rank);
		return Messages.getLeftPair() + formattedMoney + Messages.getRightPair();
	}

	public static String getCountedNumber(RankInfo rankInfo, Rank rank) {
		return rankInfo.get(rank) + Messages.getNumberUnit();
	}

	public static String getProfit(String profit) {
		String formattedProfit = ResultBuilder.decimalFormatter(profit);
		return Messages.getTotalInfo() + formattedProfit + Messages.getPERCENT();
	}

	public static String getNewLine() {
		return "\n";
	}


	// 당첨금액과 퍼센트출력형식을 제네릭을 사용해서 반복코드를 제거
	private static <T> String decimalFormatter(T originalValue) {
		String format = "#,##0.0";
		DecimalFormat numberFormatter = new DecimalFormat(format);

		if (originalValue instanceof Rank) {
			format = "###,###";
			numberFormatter = new DecimalFormat(format);
			return numberFormatter.format(((Rank) originalValue).getPrizeMoney());
		}

		return numberFormatter.format(Float.parseFloat((String) originalValue));
	}
}
