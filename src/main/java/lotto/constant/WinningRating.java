package lotto.constant;

public enum WinningRating {
	MISS(0,"0원"),
	FIFTH(3, "5,000원"),
	FOURTH(4, "50,000원"),
	THIRD(5, "1,500,000원"),
	SECOND(5, "30,000,000원"),
	FIRST(6, "2,000,000,000원");

	private final int countOfMatchedNumber;
	private final String prizeMoney;

	WinningRating(int countOfMatchedNumber, String prizeMoney) {
		this.countOfMatchedNumber = countOfMatchedNumber;
		this.prizeMoney = prizeMoney;
	}

	public int getCountOfMatchedNumber() {
		return countOfMatchedNumber;
	}

	public String getPrizeMoney() {
		return prizeMoney;
	}
}
