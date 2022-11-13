package lotto;

public enum Prize {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NONE(0, 0);

	private int winningNumberCount;
	private int winningPrice;

	Prize(int winningNumberCount, int winningPrice) {
		this.winningNumberCount = winningNumberCount;
		this.winningPrice = winningPrice;
	}

	public int getWinningPrice() {
		return this.winningPrice;
	}

	public static Prize valueOf(int winningNumberCount, boolean bonusWinning) {
		if (winningNumberCount == 6) {
			return FIRST;
		} else if (winningNumberCount == 5 && bonusWinning == true) {
			return SECOND;
		} else if (winningNumberCount == 5 && bonusWinning == false) {
			return THIRD;
		} else if (winningNumberCount == 4) {
			return FOURTH;
		} else if (winningNumberCount == 3) {
			return FIFTH;
		} else if (winningNumberCount < 3) {
			return NONE;
		}

		throw new IllegalArgumentException("[ERROR] 당첨 번호와 일치하는 개수에 오류가 있습니다.");
	}

}
