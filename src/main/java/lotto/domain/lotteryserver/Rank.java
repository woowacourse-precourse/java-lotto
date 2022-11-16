package lotto.domain.lotteryserver;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
	NOTHING(0, 0), FIFTH_RANK(3, 5_000), FOURTH_RANK(4, 50_000), THIRD_RANK(5,
		1_500_000), SECOND_RANK(5, 30_000_000), FIRST_RANK(6, 2_000_000_000);

	private final int matchedCount;
	private final int prizeMoney;

	Rank(int matchedCount, int prizeMoney) {
		this.matchedCount = matchedCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank getRank(int matchedCount, boolean bonusFlag) {
		if (matchedCount == THIRD_RANK.matchedCount && !bonusFlag) {
			return THIRD_RANK;
		}

		if (matchedCount < FIFTH_RANK.matchedCount) {
			return NOTHING;
		}

		return Arrays.stream(values()).filter(rank -> rank.matchedCount == matchedCount).findAny()
			.orElseThrow(NoSuchElementException::new);
	}

	public int getMatchedCount() {
		return matchedCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}
}
