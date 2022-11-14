package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
	FIRST(6, false, 2000000000),
	SECOND(5, true, 30000000),
	THIRD(5, false, 1500000),
	FOURTH(4, false, 50000),
	FIFTH(3, false, 5000),
	BLANK(0, false, 0);

	private final int matchCount;
	private final boolean isMatchBonusNumber;
	private final int reward;

	LottoRanking(int matchCount, boolean isMatchBonusNumber, int reward) {
		this.matchCount = matchCount;
		this.reward = reward;
		if (matchCount == 5) {
			this.isMatchBonusNumber = isMatchBonusNumber;
			return;
		}
		this.isMatchBonusNumber = false;
	}

	public static LottoRanking of(int matchCount, boolean isMatchBonusNumber) {
		return Arrays.stream(LottoRanking.values())
			.filter(lottoRanking -> lottoRanking.isMatch(matchCount, isMatchBonusNumber))
			.findFirst()
			.orElse(BLANK);
	}

	private boolean isMatch(int matchCount, boolean isMatchBonusNumber) {
		if (this.matchCount == matchCount) {
			return checkBonusNumber(matchCount, isMatchBonusNumber);
		}
		return false;
	}

	private boolean checkBonusNumber(int matchCount, boolean isMatchBonusNumber) {
		if (matchCount != 5) {
			return true;
		}
		return this.isMatchBonusNumber == isMatchBonusNumber;
	}

	public int getReward() {
		return reward;
	}
}
