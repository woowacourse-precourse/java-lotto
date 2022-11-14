package lotto.domain;

import java.util.Arrays;

public enum LottoReward {
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingNumbers;
    private final int reward;
    private int count;

    LottoReward(int matchingNumbers, int reward) {
        this.matchingNumbers = matchingNumbers;
        this.reward = reward;
    }

    public static LottoReward getRank(int numberOfMatch, boolean isContainsBonusNumber) {
        // 5개가 일치하는데, 보너스 숫자도 맞을 때
        if (numberOfMatch == SECOND.getMatchingNumbers() && isContainsBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                .findFirst()
                .orElseThrow(()
                        -> new IllegalArgumentException(Message.CANNOT_FIND_RANK));
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
