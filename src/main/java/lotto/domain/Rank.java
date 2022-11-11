package lotto.domain;

public enum Rank {

	FIRST(6, false, 2000000000, 1),
	SECOND(5, true, 30000000, 2),
	THIRD(5, false, 1500000, 3),
	FOURTH(4, false, 50000, 4),
	FIFTH(3, false, 5000, 5),
	NONE(5, false, 0, 6);

	private final int count;
	private final boolean isBonusBall;
	private final int price;
	private final int rank;

	Rank(int count, boolean isBonusBall, int price, int rank) {
		this.count = count;
		this.isBonusBall = isBonusBall;
		this.price = price;
		this.rank = rank;
	}

	public int getPrice() {
		return price;
	}

	public int getRank() {
		return rank;
	}

	public static Rank findRank(int count, boolean isBonusBall) {
		for (Rank rank : Rank.values()) {
			if (rank.isCorrect(count, isBonusBall)) {
				return rank;
			}
		}
		return NONE;
	}

	private boolean isCorrect(int count, boolean isBonusBall) {
		return this.count == count && this.isBonusBall == isBonusBall;
	}
}
