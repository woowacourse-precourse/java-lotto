package lotto.domain;

import lotto.config.InputConfig;

public enum Winner {
    FIRST(InputConfig.LOTTO_NUMBER_COUNT, false, 2000000000),
    SECOND(InputConfig.LOTTO_NUMBER_COUNT-1, true, 30000000),
    THIRD(InputConfig.LOTTO_NUMBER_COUNT-1, false, 1500000),
    FOURTH(InputConfig.LOTTO_NUMBER_COUNT-2, false, 50000),
    FIFTH(InputConfig.LOTTO_NUMBER_COUNT-3, false, 5000),
    NONE(0, false, 0);

    private int correctness;
    private boolean value;
    private int prizeMoney;

    Winner(int correctness, boolean value, int prizeMoney) {
        this.correctness = correctness;
        this.value = value;
        this.prizeMoney = prizeMoney;
    }

    public int getCorrectnessCount() {
        return correctness;
    }

    public String getPrizeMoney() {
        String formatted = String.format("%,d",prizeMoney);
        return formatted;
    }
}
