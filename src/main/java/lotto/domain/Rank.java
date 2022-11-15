package lotto.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum Rank {
	NOTHING(0, false, 0, ""),
	FIFTH(3, false, 5000, "3개 일치"),
	FOURTH(4, false, 50000, "4개 일치"),
	THIRD(5, false, 1500000, "5개 일치"),
	SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
	FIRST(6, false,2000000000, "6개 일치");

	public static final int BONUS_MATCH = 5;

	private final int numberOfMatching;
	private final boolean hasBonusNumber;
	private final int prize;
	private final String message;

	Rank(int numberOfMatching, boolean hasBonusNumber, int prize, String message) {
		this.numberOfMatching = numberOfMatching;
		this.hasBonusNumber = hasBonusNumber;
		this.prize = prize;
		this.message = message;
	}

	public static Rank getRank(int numberOfMatching, boolean hasBonusNumber) {
		return Arrays.stream(values())
				.filter(rank -> rank.numberOfMatching == numberOfMatching)
				.filter(rank -> numberOfMatching != BONUS_MATCH || (numberOfMatching == BONUS_MATCH && rank.hasBonusNumber == hasBonusNumber))
				.findAny()
				.orElse(NOTHING);
	}
	public int getNumberOfMatching() {
		return numberOfMatching;
	}

	public int getPrize() {
		return prize;
	}

	public String getMessage() {
		return message;
	}

}
