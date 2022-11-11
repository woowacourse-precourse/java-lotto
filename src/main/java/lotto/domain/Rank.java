package lotto.domain;

public enum Rank {

	FIRST(6, false, 2000000000),
	SECOND(5, true, 30000000),
	THIRD(5, false, 1500000),
	FOURTH(4, false, 50000),
	FIFTH(3, false, 5000),
	NONE(0, false, 0);

	private final int count;
	private final boolean isBonusBall;
	private final int price;

	Rank(int count, boolean isBonusBall, int price) {
		this.count = count;
		this.isBonusBall = isBonusBall;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public static Rank findRank(int count, boolean isBonusBall) {
		for (Rank rank :  Rank.values()) {
			if(rank.isCorrect(count, isBonusBall)){
				return rank;
			}
		}
		return NONE;
	}

	private boolean isCorrect(int count, boolean isBonusBall) {
		return this.count == count && this.isBonusBall == isBonusBall;
	}
}
