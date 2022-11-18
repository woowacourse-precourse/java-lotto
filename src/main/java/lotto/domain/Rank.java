package lotto.domain;

public enum Rank {
	FIRST(2_000_000_000),
	SECOND(30_000_000),
	THIRD(1_500_000),
	FOURTH(50_000),
	FIFTH(5_000),
	MISS(0);

	private int winningMoney;

	private Rank(int winningMoney) {
		this.winningMoney = winningMoney;
	}

	public int getWinningMoneyByRank() {
		return winningMoney;
	}
}