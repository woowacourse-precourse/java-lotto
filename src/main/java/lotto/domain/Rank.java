package lotto.domain;

import java.util.Arrays;

import lotto.util.Const;

public enum Rank {
	fifthRank(5_000, Const.FIFTH_RANK_RESULT),
	forthRank(50_000, Const.FORTH_RANK_RESULT),
	thirdRank(1_500_000, Const.THIRD_RANK_RESULT),
	secondRank(30_000_000, Const.SECOND_RANK_RESULT),
	firstRank(2_000_000_000, Const.FIRST_RANK_RESULT);

	private final Integer price;
	private final String priceWon;
	private Integer count;

	Rank(int price, String priceWon) {
		this.price = price;
		this.priceWon = priceWon;
		this.count = 0;
	}

	public static double findYield(Integer buyPrice) {
		double sum = Arrays.stream(Rank.values())
			.mapToDouble(i -> i.price * i.count)
			.reduce(0, (total, y) -> total + y);
		return Math.round(sum * 1000d / (double)buyPrice) / 10d;
	}

	public void updateCount(Integer number) {
		this.count += number;
	}

	public String getUserStatisticsResult() {
		return this.priceWon + this.count + Const.COUNT;
	}

}
