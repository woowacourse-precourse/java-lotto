package lotto.models;

import java.util.Arrays;

import static lotto.constants.Constant.*;

public enum Rank {
	FIFTH(5), FOURTH(4), THIRD(3),
	SECOND(2), FIRST(1), NONE(-1);

	private final int rankValue;

	Rank(int rankValue) {
		this.rankValue = rankValue;
	}

	public boolean isOutOfRank() {
		return this.rankValue == NONE.rankValue;
	}

	public static Rank getRank(int rankValue) {
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.rankValue == rankValue)
				.findFirst().orElse(NONE);
	}

	public static Rank getRankByMatchedNumberCount(int matchedNumberCount) {
		if (ranks.containsKey(matchedNumberCount)) {
			return ranks.get(matchedNumberCount);
		}

		return NONE;
	}
}
