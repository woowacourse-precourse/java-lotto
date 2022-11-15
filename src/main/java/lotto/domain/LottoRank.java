package lotto.domain;

public enum LottoRank {
    FIFTH(3, 0, 5_000, "3개 일치 (5,000원) - "),
    FORTH(4, 0, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 0, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 0, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    MISS(0, 0, 0, "낙첨");

    private final int count;
    private final int bonusCount;
    private final long rewardMoney;
    private final String message;

    LottoRank(int count, int bonusCount, long rewardMoney, String message) {
        this.count = count;
        this.bonusCount = bonusCount;
        this.rewardMoney = rewardMoney;
        this.message = message;
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

    public String getMessage() {
        return message;
    }
}
