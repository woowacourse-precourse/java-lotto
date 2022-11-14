package lotto;

public enum LottoRank {
	FIRST_PLACE(6, 2_000_000_000),
	SECOND_PLACE(5, 30_000_000),
	THIRD_PLACE(5, 1_500_000),
	FOURTH_PLACE(4, 50_000),
	FIFTH_PLACE(3, 5_000);
	private int sameNumber;
	private int winnerPrize;

	LottoRank(int sameNumber, int winnerPrice) {
		this.sameNumber = sameNumber;
		this.winnerPrize = winnerPrice;

	}

	public int getWinnerPrize() {
		return winnerPrize;
	}

	public int getSameNumber() {
		return sameNumber;
	}

}
