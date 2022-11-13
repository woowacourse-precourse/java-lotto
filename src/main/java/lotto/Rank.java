package lotto;

import java.util.Arrays;

public enum Rank {
	FIRST(2000000000),
	SECOND(30000000),
	THIRD(1500000),
	FOURTH(50000),
	FIFTH(5000),
	NOTHING(0);

	private final int money;

	Rank(int money) {
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

	public int getMoney() {
		return money;
	}
}
