package lotto.constant;

public enum WinningRating {
	MISS(0, 0, false),
	FIFTH(3, 5000, false),
	FOURTH(4, 50000, false),
	THIRD(5, 1500000L, false),
	SECOND(5, 30000000L, true),
	FIRST(6, 2000000000L, false);

	private final int countOfMatchedNumber;
	private final long prizeMoney;
	private final boolean isUsingBonusNumber;

	WinningRating(int countOfMatchedNumber, long prizeMoney, boolean isUsingBonusNumber) {
		this.countOfMatchedNumber = countOfMatchedNumber;
		this.prizeMoney = prizeMoney;
		this.isUsingBonusNumber = isUsingBonusNumber;
	}

	public int getCountOfMatchedNumber() {
		return countOfMatchedNumber;
	}

	public long getPrizeMoney() {
		return prizeMoney;
	}

	public boolean getIsUsingBonusNumber() {
		return isUsingBonusNumber;
	}
}
