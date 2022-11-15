package lotto.domain;

import java.util.Arrays;

public enum Prize {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NONE(0, 0);

	private final int winningNumberCount;
	private final int winningPrice;

	Prize(int winningNumberCount, int winningPrice) {
		this.winningNumberCount = winningNumberCount;
		this.winningPrice = winningPrice;
	}

	public int getWinningPrice() {
		return this.winningPrice;
	}

	public static Prize valueOf(int winningNumberCount, boolean bonusWinning) {
		if (winningNumberCount == 5) {
			if (bonusWinning == true) {
				return Prize.SECOND;
			}

			return Prize.THIRD;
		}

		return Arrays.stream(Prize.values())
				.filter(prize -> prize.winningNumberCount == winningNumberCount)
				.findAny()
				.orElse(NONE);
	}
}
