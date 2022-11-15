package lotto.model;

import java.util.Arrays;

public enum LottoRanking {

	EMPTY(0, 0),
	FIFTH(3, 5000),
	FOURTH(4, 50000),
	THIRD(5, 1500000),
	SECOND(5, 30000000),
	FIRST(6, 2000000000);

	private final int ranking;
	private final int reward;

	LottoRanking(int ranking, int reward) {
		this.ranking = ranking;
		this.reward = reward;
	}

	public static LottoRanking findByLottoRanking(int matchCount, Boolean hasBonus) {
		if (hasBonus) {
			return SECOND;
		}

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
