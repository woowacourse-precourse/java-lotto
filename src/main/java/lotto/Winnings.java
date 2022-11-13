package lotto;

public enum Winnings {
	FIRST_PLACE(2_000_000_000),
	SECOND_PLACE(30_000_000),
	THIRD_PLACE(1_500_000),
	FOURTH_PLACE(50_000),
	FIFTH_PLACE(5_000);
	
	private final int prize;
	
	Winnings(int prize) {
		this.prize = prize;
	}
	
	public int getPrize() {
		return prize;
	}
	
}
