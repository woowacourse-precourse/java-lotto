package lotto.constant;

import lotto.domain.LottoResult;

public enum LottoAward {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(0, 0, 0);

    private final int normalCount;
    private final int bonusCount;
    private final int reward;

    LottoAward(int normalCount, int bonusCount, int reward) {
        this.normalCount = normalCount;
        this.bonusCount = bonusCount;
        this.reward = reward;
    }

    public static LottoAward getAwardFrom(LottoResult lottoResult) {
        int normalMatchedCount = lottoResult.getNormalCount();
        int bonusMatchedCount = lottoResult.getBonusCount();

        if (normalMatchedCount == SECOND.getNormalCount() &&
                bonusMatchedCount == SECOND.getBonusCount()) {
            return SECOND;
        }

        for (LottoAward award : values()) {
            if (isMatchedWithCount(normalMatchedCount, award) && award != SECOND) {
                return award;
            }
        }

        return NONE;
    }

    private static boolean isMatchedWithCount(int normalMatchedCount, LottoAward award) {
        return normalMatchedCount == award.getNormalCount();
    }

    public int getNormalCount() {
        return normalCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public int getReward() {
        return reward;
    }
}
