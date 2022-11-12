package lotto.model;

import java.util.Arrays;

public enum LottoRanking {

	FIRST(6, 2000000000),
	SECOND(22, 30000000),
	THIRD(5, 1500000),
	FOURTH(4, 50000),
	FIFTH(3, 5000),
	EMPTY(0, 0);

	final static public int SECOND_RANKING = 22;
	private final int ranking;
	private final int reward;

	LottoRanking(int ranking, int reward) {
		this.ranking = ranking;
		this.reward = reward;
	}

	public static LottoRanking findByLottoRanking(int matchCount) {
		return Arrays.stream(LottoRanking.values())
			.filter(ranking -> ranking.isWin(matchCount))
			.findAny()
			.orElse(EMPTY);
	}

	private boolean isWin(int matchCount) {
		return matchCount == this.ranking;
	}

	public int getReward() {
		return reward;
	}
}
