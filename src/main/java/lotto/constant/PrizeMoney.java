package lotto.constant;

public enum PrizeMoney {
	FIRST(2_000_000_000),
	SECOND(30_000_000),
	THIRD(1_500_000),
	FOURTH(50_000),
	FIFTH(5_000);

	private final int prize;

	PrizeMoney(int prize) {
		this.prize = prize;
	}

	public int getPrize() {
		return prize;
	}
}
