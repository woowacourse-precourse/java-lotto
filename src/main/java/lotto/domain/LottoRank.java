package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

	NON_PRIZE(0, false, 0),
	FIFTH_PRIZE(3, false, 5000),
	FOURTH_PRIZE(4, false, 50000),
	THIRD_PRIZE(5, false, 1500000),
	SECOND_PRIZE(5, true, 30000000),
	FIRST_PRIZE(6, false, 2000000000);

	private final int numberCount;
	private final boolean correctBonus;
	private final int reward;

	LottoRank(int numberCount, boolean correctBonus, int reward) {
		this.numberCount = numberCount;
		this.correctBonus = correctBonus;
		this.reward = reward;
	}

	public static LottoRank award(int numberCount, boolean correctBonus) {
		return Arrays.stream(LottoRank.values())
			.filter(prize -> prize.numberCount == numberCount && prize.correctBonus == correctBonus)
			.findAny()
			.orElse(NON_PRIZE);
	}

	public int getNumberCount() {
		return numberCount;
	}

	public boolean isCorrectBonus() {
		return correctBonus;
	}

	public int getReward() {
		return reward;
	}
}
