package model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NOTHING(0, 0, false);

    private final int lottoReward;
    private final int sameNumberCount;
    private final boolean bonus;

    LottoRank(int lottoReward, int sameNumberCount, boolean bonus) {
        this.lottoReward = lottoReward;
        this.sameNumberCount = sameNumberCount;
        this.bonus = bonus;
    }

    public static LottoRank getLottoReward(int count, boolean bonus) {
        return Arrays.stream(LottoRank.values()).filter(lottoRank -> lottoRank.sameNumberCount == count && lottoRank.bonus == bonus)
                .findAny()
                .orElse(NOTHING);
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getLottoReward() {
        return lottoReward;
    }

}
