package lotto.model;

public enum PrizeType {
    PRIZE1(6, 0, 2_000_000_000),
    PRIZE2(5, 1, 30_000_000),
    PRIZE3(5, 0, 1_500_000),
    PRIZE4(4, 0, 50_000),
    PRIZE5(3, 0, 5_000);

    private final int matchCount;
    private final int bonusCount;
    private final int rewardMoney;

    private PrizeType(int matchCount, int bonusCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.rewardMoney = rewardMoney;
    }
}
