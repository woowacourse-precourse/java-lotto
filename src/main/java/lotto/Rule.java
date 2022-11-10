package lotto;

public enum Rule {
	FIRST_PRIZE(6, "2,000,000,000원"),
	SECOND_PRIZE(5, "30,000,000원"),
	THIRD_PRIZE(4, "1,500,000원"),
	FOURTH_PRIZE(3, "50,000원"),
	FIFTH_PRIZE(2, "5,000원");

	private final int matches;
	private final String reward;

	Rule(int matches, String reward) {
		this.matches = matches;
		this.reward = reward;
	}

	public int getMatches() {
		return matches;
	}
	public String getReward() {
		return reward;
	}
}
