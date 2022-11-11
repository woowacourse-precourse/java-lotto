package lotto.domain;

public enum LottoRanking {
	winThree(5000),
	winFour(50000),
	winFive(1500000),
	winFiveBonus(30000000),
	winSix(2000000000);

	private final int prizeMoney;

	LottoRanking(int prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	public int getMoney() {
		return prizeMoney;
	}
}
