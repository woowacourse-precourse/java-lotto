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
		DecimalFormat numberFormatter = new DecimalFormat("###,###");
		String money = numberFormatter.format(rank.getPrizeMoney());
		return Messages.getLeftPair() + money + Messages.getRightPair();
	}

	public static String getCountedNumber(RankInfo rankInfo, Rank rank) {
		return rankInfo.get(rank) + Messages.getNumberUnit();
	}

	public static String getProfit(String profit) {
		return Messages.getTotalInfo() + profit + Messages.getPERCENT();
	}

	public static String getNewLine() {
		return "\n";
	}
}
