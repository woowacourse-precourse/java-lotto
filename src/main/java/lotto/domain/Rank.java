package lotto.domain;

import lotto.config.InputConfig;

public enum Rank {
    FIFTH(InputConfig.LOTTO_NUMBER_COUNT-3,  5000),
    FOURTH(InputConfig.LOTTO_NUMBER_COUNT-2, 50000),
    THIRD(InputConfig.LOTTO_NUMBER_COUNT-1,  1500000),
    SECOND(InputConfig.LOTTO_NUMBER_COUNT-1,  30000000),
    FIRST(InputConfig.LOTTO_NUMBER_COUNT,  2000000000),
    NONE(0, 0);

    private int correctness;
    private int prizeMoney;

    Rank(int correctness, int prizeMoney) {
        this.correctness = correctness;
        this.prizeMoney = prizeMoney;
    }

    public int getCorrectnessCount() {
        return correctness;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public String getPrizeMoneyToString() {
        String formatted = String.format("%,d",prizeMoney);
        return formatted;
    }
}
