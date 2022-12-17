package lotto;

public enum WinnerCount {
	MIN_WINNER_MATCH_COUNT(3),
	FIRST_WINNER_MATCH_COUNT(6),
	SECOND_WINNER_MATCH_COUNT(5);

	private int matchCount;

	WinnerCount(int matchCount) {
		this.matchCount = matchCount;
	}

	public int getMatchCount() {
		return matchCount;
	}
}
