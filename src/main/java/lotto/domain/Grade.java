package lotto.domain;

import java.util.Arrays;

public enum Grade {
	FIFTH(5_000, 3, false),
	FORTH(50_000, 4, false),
	THIRD(1_500_000, 5, false),
	SECOND(30_000_000, 5, true),
	FIRST(2_000_000_000, 6, false),
	DEFAULT(0, 0, false);
	private static final int SECOND_OR_THIRD_WINNING_NUMBER_COUNT = 5;
	private final int cashPrize;
	private final int winningNumberCount;
	private final boolean hasBonusNumber;

	Grade(int cashPrize, int winningNumberCount, boolean hasBonusNumber) {
		this.cashPrize = cashPrize;
		this.winningNumberCount = winningNumberCount;
		this.hasBonusNumber = hasBonusNumber;
	}

	public static Grade findGrade(int winningNumberCount, boolean hasBonusNumber) {
		if (winningNumberCount == SECOND_OR_THIRD_WINNING_NUMBER_COUNT) {
			return findSecondOrThird(winningNumberCount, hasBonusNumber);
		}
		return findOthers(winningNumberCount);
	}

	private static Grade findSecondOrThird(int winningNumberCount, boolean hasBonusNumber) {
		return Arrays.stream(Grade.values())
			.filter(value -> value.winningNumberCount == winningNumberCount)
			.filter(value -> value.hasBonusNumber == hasBonusNumber)
			.findAny()
			.orElse(DEFAULT);
	}

	private static Grade findOthers(int winningNumberCount) {
		return Arrays.stream(Grade.values())
			.filter(value -> value.winningNumberCount == winningNumberCount)
			.findAny()
			.orElse(DEFAULT);
	}

	public int getCashPrize() {
		return cashPrize;
	}

	public int getWinningNumberCount() {
		return winningNumberCount;
	}
}
