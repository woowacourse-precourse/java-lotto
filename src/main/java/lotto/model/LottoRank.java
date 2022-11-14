package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, false,2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true,30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false,1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, false,50_000L, "4개 일치 (50,000원)"),
    FIFTH(3, false,5_000L, "3개 일치 (5,000원)"),
    NONE(0, false,0L, "0");

    private final int correctCount;
    private final long reward;
    private final boolean isBonus;
    private final String rewardMessage;

    LottoRank(int correctCount, boolean isBonus, long reward, String rewardMessage) {
        this.correctCount = correctCount;
        this.reward = reward;
        this.isBonus = isBonus;
        this.rewardMessage = rewardMessage;
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
            .sorted(Comparator.comparingInt(l -> l.correctCount))
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

    public String getRewardMessage() {
        return rewardMessage;
    }
}
