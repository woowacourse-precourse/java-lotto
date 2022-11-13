package lotto.domain;

import lotto.util.RankConst;

public enum Rank {
	fifthRank(5_000, RankConst.FIFTH_RANK_RESULT),
	forthRank(50_000, RankConst.FORTH_RANK_RESULT),
	thirdRank(1_500_000, RankConst.THIRD_RANK_RESULT),
	secondRank(30_000_000, RankConst.SECOND_RANK_RESULT),
	firstRank(2_000_000_000, RankConst.FIRST_RANK_RESULT);

	private final Integer price;
	private final String rankCountDescription;

	Rank(int price, String rankCountDescription) {
		this.price = price;
		this.rankCountDescription = rankCountDescription;
	}

	public Integer getPrice() {
		return price;
	}

	public String getRankCountDescription() {
		return rankCountDescription;
	}
}
