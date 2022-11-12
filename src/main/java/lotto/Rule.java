package lotto;

public enum Rule {
	FIFTH_PRIZE(3, "5,000원"),
	FOURTH_PRIZE(4, "50,000원"),
	THIRD_PRIZE(5, "1,500,000원"),
	SECOND_PRIZE(5, "30,000,000원"),
	FIRST_PRIZE(6, "2,000,000,000원");

	private final String reward;
	private final int match;

	Rule(int match, String reward) {
		this.match = match;
		this.reward = reward;
	}

	public String getReward() {
		return reward;
	}

	public int getMatches() {
		return match;
	}
}
