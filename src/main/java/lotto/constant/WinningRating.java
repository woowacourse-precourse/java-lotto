package lotto.constant;

public enum WinningRating {
	MISS(0,"0원", false),
	FIFTH(3, "5,000원", false),
	FOURTH(4, "50,000원", false),
	THIRD(5, "1,500,000원", false),
	SECOND(5, "30,000,000원", true),
	FIRST(6, "2,000,000,000원", false);

	private final int countOfMatchedNumber;
	private final String prizeMoney;
	private final boolean isUsingBonusNumber;

	WinningRating(int countOfMatchedNumber, String prizeMoney, boolean isUsingBonusNumber) {
		this.countOfMatchedNumber = countOfMatchedNumber;
		this.prizeMoney = prizeMoney;
		this.isUsingBonusNumber = isUsingBonusNumber;
	}

	public int getCountOfMatchedNumber() {
		return countOfMatchedNumber;
	}

	public String getPrizeMoney() {
		return prizeMoney;
	}
	public boolean getIsUsingBonusNumber() {
		return isUsingBonusNumber;
	}
}
