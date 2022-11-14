package lotto.model;

import java.util.Arrays;

public enum PrizeType {
    PRIZE1(6, 0, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    PRIZE2(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRIZE3(5, 0, 1_500_000, "5개 일치 (1,500,000원) - "),
    PRIZE4(4, 0, 50_000, "4개 일치 (50,000원) - "),
    PRIZE5(3, 0, 5_000, "3개 일치 (5,000원) - ");

    private final int matchCount;
    private final int bonusCount;
    private final int rewardMoney;
    private final String resultText;

    private PrizeType(int matchCount, int bonusCount, int rewardMoney, String resultText) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.rewardMoney = rewardMoney;
        this.resultText = resultText;
    }

    public static PrizeType getRank(int matchCount, int bonusCount) {
        return Arrays.stream(values())
            .filter(prize -> prize.matchCount == matchCount)
            .filter(prize -> prize.bonusCount == bonusCount)
            .findFirst()
            .orElse(null);
    }

    public int getReward() {
        return this.rewardMoney;
    }

    public String getResultText() {
        return this.resultText;
    }
}
