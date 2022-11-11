package lotto.domain;

public enum Rank {
	RANK_5TH(3, false, 5000),
	RANK_4TH(4, false, 50000),
	RANK_3RD(5, false, 1500000),
	RANK_2ND(5, true, 30000000),
	RANK_1ST(6, false, 2000000000),
	NO_RANK(0, false, 0);

	private final int sameNumberCount;
	private final boolean bonusBall;
	private final int reward;

	Rank(int sameNumberCount, boolean bonusBall, int reward) {
		this.sameNumberCount = sameNumberCount;
		this.bonusBall = bonusBall;
		this.reward = reward;
	}

	public int getSameWinningNumberCount() {
		return sameNumberCount;
	}

	public int getReward() {
		return reward;
	}

	public static Rank getRank(int sameNumberCount, boolean bonusNumber) {
		if (sameNumberCount == RANK_1ST.getSameWinningNumberCount()) {
			return RANK_1ST;
		}
		if (sameNumberCount == RANK_2ND.getSameWinningNumberCount() && RANK_2ND.bonusBall == bonusNumber) {
			return RANK_2ND;
		}
		if (sameNumberCount == RANK_3RD.getSameWinningNumberCount()) {
			return RANK_3RD;
		}
		if (sameNumberCount == RANK_4TH.getSameWinningNumberCount()) {
			return RANK_4TH;
		}
		if (sameNumberCount == RANK_5TH.getSameWinningNumberCount()) {
			return RANK_5TH;
		}
		return NO_RANK;
	}
}
