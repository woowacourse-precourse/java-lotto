package lotto.domain;

import lotto.util.RankConst;

public enum Rank {
	fifthRank(RankConst.FIFTH_RANK_PRICE, RankConst.FIFTH_RANK_RESULT),
	forthRank(RankConst.FORTH_RANK_PRICE, RankConst.FORTH_RANK_RESULT),
	thirdRank(RankConst.THIRD_RANK_PRICE, RankConst.THIRD_RANK_RESULT),
	secondRank(RankConst.SECOND_RANK_PRICE, RankConst.SECOND_RANK_RESULT),
	firstRank(RankConst.FIRST_RANK_PRICE, RankConst.FIRST_RANK_RESULT);

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
