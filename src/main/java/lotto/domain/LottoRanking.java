package lotto.domain;

public enum LottoRanking {
	winThree(5000, 3),
	winFour(50000, 4),
	winFive(1500000, 5),
	winFiveBonus(30000000, 5),
	winSix(2000000000, 6);

	private final int prizeMoney;
	private final int winNumber;

	LottoRanking(int prizeMoney, int winNumber) {
		this.prizeMoney = prizeMoney;
		this.winNumber = winNumber;
	}

	public int getMoney() {
		return prizeMoney;
	}
}
