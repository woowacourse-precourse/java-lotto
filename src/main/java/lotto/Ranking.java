package lotto;

public enum Ranking {

	NUMBER_TO_CONVERT_SCORE_TO_RANK(3),
	PERFECT(6),
	SCORE(1),
	FIRST_PLACE(4),
	SECOND_PLACE(3),
	THIRD_PLACE(2),
	FOURTH_PLACE(1),
	FIFTY_PLACE(0);

	private final int value;

	Ranking(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
