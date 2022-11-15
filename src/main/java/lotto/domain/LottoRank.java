package lotto.domain;

public enum LottoRank {
    FIFTH(3, 0, 5_000),
    FORTH(4, 0, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND(5, 1, 30_000_000),
    FIRST(6, 0, 2_000_000_000),
    MISS(0, 0, 0);

    private final int count;
    private final int bonusCount;
    private final long rewardMoney;

    LottoRank(int count, int bonusCount, long rewardMoney) {
        this.count = count;
        this.bonusCount = bonusCount;
        this.rewardMoney = rewardMoney;
    }

    public static LottoRank getLottoRank(final int matchCount, final int bonusCount) {
        if (matchCount == FIFTH.count) { return FIFTH; }
        if (matchCount == FORTH.count) { return FORTH; }
        if (matchCount == THIRD.count && bonusCount == THIRD.bonusCount) { return THIRD; }
        if (matchCount == SECOND.count && bonusCount == SECOND.bonusCount) { return SECOND; }
        if (matchCount == FIRST.count) { return FIRST; }
        return MISS;
    }

    public int getRank() {
        return count;
    }

    public long getRewardMoney() {
        return rewardMoney;
    }
}
