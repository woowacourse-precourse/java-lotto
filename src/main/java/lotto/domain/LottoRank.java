package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH_PRIZE(3, 5000, false),
    FOURTH_PRIZE(4, 50000, false),
    THIRD_PRIZE(5, 1500000, false),
    SECOND_PRIZE(5, 30000000, true),
    FIRST_PRIZE(6, 2000000000, false),
    MISS_PRIZE(0, 0, false);

    private int correctCount;
    private int lottoReward;
    private boolean haveBonusNumber;

    LottoRank(int correctCount, int lottoReward, boolean haveBonusNumber) {
        this.correctCount = correctCount;
        this.lottoReward = lottoReward;
        this.haveBonusNumber = haveBonusNumber;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getLottoReward() {
        return lottoReward;
    }

    public boolean isHaveBonusNumber() {
        return haveBonusNumber;
    }

    public static LottoRank getRank(int correctCount, boolean haveBonusNumber) {
        for (LottoRank rank : values()) {
            if (rank.getCorrectCount() == correctCount && rank.isHaveBonusNumber() == haveBonusNumber) {
                return rank;
            }
        }
        return MISS_PRIZE;
    }
}
