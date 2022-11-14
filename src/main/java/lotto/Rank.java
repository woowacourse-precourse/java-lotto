package lotto;

public enum Rank {
	FIRST(6, 2000000000),
	SECOND(5, 30000000),
	THIRD(4, 1500000),
	FOURTH(3, 50000),
	FIFTH(2, 5000),
	NOTHING(0, 0);

	private final int matchCount;
	private final int money;

	Rank(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public static Rank setRank(int matchCount, boolean matchBonus) {
		if (matchCount == 6) {
			return FIRST;
		}
		if (matchCount == 5) {
			return matchBonus ? SECOND : THIRD;
		}
		if (matchCount == 4) {
			return FOURTH;
		}
		if (matchCount == 3) {
			return FIFTH;
		}
		return NOTHING;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
