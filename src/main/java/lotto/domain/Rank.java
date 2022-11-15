package lotto.domain;

import lotto.config.InputConfig;

public enum Rank {
    FIFTH(InputConfig.LOTTO_NUMBER_COUNT - 3, false, 5000),
    FOURTH(InputConfig.LOTTO_NUMBER_COUNT - 2, false, 50000),
    THIRD(InputConfig.LOTTO_NUMBER_COUNT - 1, false, 1500000),
    SECOND(InputConfig.LOTTO_NUMBER_COUNT - 1, true, 30000000),
    FIRST(InputConfig.LOTTO_NUMBER_COUNT, false, 2000000000),
    NONE(0, false, 0);

    private int correctness;
    private boolean bonusFlag;
    private int prizeMoney;

    Rank(int correctness, boolean bonusFlag, int prizeMoney) {
        this.correctness = correctness;
        this.bonusFlag = bonusFlag;
        this.prizeMoney = prizeMoney;
    }

    public boolean matchRank(int cnt, boolean bonusFlag) {
        return cnt == this.correctness && bonusFlag == this.bonusFlag;
    }

    public int getCorrectnessCount() {
        return correctness;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public String getPrizeMoneyToString() {
        String formatted = String.format("%,d", prizeMoney);
        return formatted;
    }
}
