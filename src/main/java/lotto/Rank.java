package lotto;

public enum Rank {
	RANK0(0, 0, 0),
	RANK1(6, 1, 2000000000),
	RANK2(5, 2, 30000000),
	RANK3(5, 3, 1500000),
	RANK4(4, 4, 50000),
	RANK5(3, 5, 5000);

	private final int match;
	private final int ranking;
	private final int price;

	private Rank(int match, int ranking, int price) {
		this.match = match;
		this.ranking = ranking;
		this.price = price;
	}

	public int getMatch() {
		return this.match;
	}

	public int getRanking() {
		return this.ranking;
	}

	public int getPrice() {
		return this.price;
	}
}
