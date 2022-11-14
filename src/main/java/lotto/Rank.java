package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

	FIFTH(5_000, 3, false),
	FOURTH(50_000, 4, false),
	THIRD(1_500_000, 5, false),
	SECOND(30_000_000, 5, true),
	FIRST(2_000_000_000, 6, false),
	NO_PRIZE(0,0,false);

	private final int prizeMoney;
	private final int correctNumber;
	private final boolean judgmentBonus;

	Rank(int prizeMoney, int correctNumber, boolean judgmentBonus) {
		this.prizeMoney = prizeMoney;
		this.correctNumber = correctNumber;
		this. judgmentBonus = judgmentBonus;
	}

	public static Rank of(int correctNumber, boolean bonus) {
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.isMatch(correctNumber, bonus))
				.findFirst()
				.orElse(NO_PRIZE);
	}

	private boolean isMatch(int correctNumber, boolean bonus) {
		if (isSameCorrectNumber(correctNumber)) {
			return checkBonus(bonus);
		}

		return false;
	}

	private boolean isSameCorrectNumber(int correctNumber) {
		return this.correctNumber == correctNumber;
	}

	private boolean checkBonus(boolean bonus) {
		if (judgmentBonus == bonus) {
			return true;
		}

		return false;
	}

	public static List<Rank> getKeyWithoutDefault() {
		return Arrays.stream(Rank.values())
				.filter(rank -> !rank.equals(NO_PRIZE))
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
	}

	public boolean isJudgmentBonus() {
		return judgmentBonus;
	}

	public int getCorrectNumber() {
		return correctNumber;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}
}
