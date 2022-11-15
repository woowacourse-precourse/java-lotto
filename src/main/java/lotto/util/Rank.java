package lotto.util;

import java.util.Arrays;

public enum Rank {
	NOTHING(0, 0),
	FIFTH(3, 5000),
	FOURTH(4, 50000),
	THIRD(5, 1500000),
	SECOND(5, 30000000),
	FIRST(6, 2000000000);
	private final int matchCount;
	private final int money;

	Rank(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public static Rank setRank(int matchCount, boolean matchBonus) {
		if (matchCount == SECOND.matchCount) {
			return matchBonus ? SECOND : THIRD;
		}
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.matchCount == matchCount)
				.findFirst()
				.orElse(NOTHING);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
