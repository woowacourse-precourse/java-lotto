package lotto.domain.win;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Winning {
	NOTHING(0, 0),
	FIFTH(3, 5000),

	FOURTH(4, 50000),
	THIRD(5, 1500000),
	SECOND(5, 30000000),

	FIRST(6, 2000000000);


	private int matchCount;
	private int money;

	Winning(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}
	public static Winning getWinning(int matchCount,boolean containsBonusNumber){
		if (matchCount == THIRD.matchCount && containsBonusNumber) {
			return SECOND;
		}

		if (matchCount < FIFTH.matchCount) {
			return NOTHING;
		}

		return Arrays.stream(values()).filter(winning -> winning.matchCount == matchCount).findAny()
				.orElse(NOTHING);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
