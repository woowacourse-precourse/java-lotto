package lotto.domain;

public enum Winnings {
	FIRST_PLACE(1, 2_000_000_000),
	SECOND_PLACE(2, 30_000_000),
	THIRD_PLACE(3, 1_500_000),
	FORTH_PLACE(4, 50_000),
	FIFTH_PLACE(5, 5_000);
	
	private final int rank;
	private final int amount;

	Winnings(int rank, int amount) {
		this.rank = rank;
		this.amount = amount;
	}
	
}
