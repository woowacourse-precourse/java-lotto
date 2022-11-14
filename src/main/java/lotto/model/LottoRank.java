package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, false,2_000_000_000L, "2,000,000,000"),
    SECOND(5, true,30_000_000L, "30,000,000"),
    THIRD(5, false,1_500_000L, "1,500,000"),
    FOURTH(4, false,50_000L, "50,000"),
    FIFTH(3, false,5_000L, "5,000"),
    NONE(0, false,0L, "0");

    private final int correctCount;
    private final long reward;
    private final boolean isBonus;
    private final String rewardStr;

    LottoRank(int correctCount, boolean isBonus, long reward, String rewardStr) {
        this.correctCount = correctCount;
        this.reward = reward;
        this.isBonus = isBonus;
        this.rewardStr = rewardStr;
    }

    public static LottoRank findLottoRank(int correctCount, boolean isBonus) {
        return Arrays.stream(LottoRank.values())
            .filter(l -> l.correctCount == correctCount && l.isBonus == isBonus)
            .findFirst()
            .orElse(LottoRank.NONE);
    }

    public static List<LottoRank> getLottoRankList() {
        return Arrays.stream(LottoRank.values())
            .filter(l -> l !=LottoRank.NONE)
            .sorted((l1, l2) -> l1.correctCount - l2.correctCount)
            .collect(Collectors.toList());
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getReward() {
        return reward;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public String getRewardStr() {
        return rewardStr;
    }
}
