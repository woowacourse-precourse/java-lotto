package lotto;

public enum Rank {
	RANK1(1, 2000000000),
	RANK2(2, 30000000),
	RANK3(3, 1500000),
	RANK4(4, 50000),
	RANK5(5, 5000);

	private final int ranking;
	private final int price;

	private Rank(int ranking, int price) {
		this.ranking = ranking;
		this.price = price;
	}

	public int getRanking() {
		return this.ranking;
	}

	public int getPrice() {
		return this.price;
	}
}
