package lotto;

import java.util.Arrays;

public enum LottoReward {
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 3_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingNumbers;
    private final int reward;
    private int count;

    LottoReward(int matchingNumbers, int reward) {
        this.matchingNumbers = matchingNumbers;
        this.reward = reward;
    }

    public static LottoReward getRank(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void plusCount() {
        this.count++;
    }

    public int getReward() {
        return this.reward;
    }

    public int getCount() {
        return this.count;
    }

    public int getMatchingNumbers() {
        return this.matchingNumbers;
    }
}
