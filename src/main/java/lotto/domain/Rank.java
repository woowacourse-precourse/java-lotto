package lotto.domain;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private final int hitNumberCount;
	private final int prizeMoney;

	Rank(int hitNumberCount, int prizeMoney) {
		this.hitNumberCount = hitNumberCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank of(int hitNumberCount, boolean isContainsBonusNumber) {
		if (isContainsBonusNumber && SECOND.hitNumberCount == hitNumberCount) {
			return SECOND;
		}

		return Arrays.stream(values())
			.filter(Rank -> ((Rank != SECOND) && Rank.hitNumberCount == hitNumberCount))
			.findFirst()
			.orElse(MISS);
	}

	public int getHitNumberCount() {
		return hitNumberCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

}
