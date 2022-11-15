package lotto.domain.constants;

public enum LottoRank {
    RANK_LOSE(0, false, 0),
    RANK_5(3, false, 5_000),
    RANK_4(4, false, 50_000),
    RANK_3(5, false, 1_500_000),
    RANK_2(5, true, 30_000_000),
    RANK_1(6, false, 2_000_000_000);

    private final int requiredMatchCount;
    private final boolean requiredToCheckBonus;
    private final int prize;

    LottoRank(int requiredMatchCount, boolean requiredToCheckBonus, int prize) {
        this.requiredMatchCount = requiredMatchCount;
        this.requiredToCheckBonus = requiredToCheckBonus;
        this.prize = prize;
    }

    public int getRequiredMatchCount() {
        return requiredMatchCount;
    }

    public boolean isRequiredToCheckBonus() {
        return requiredToCheckBonus;
    }

    public int getPrize() {
        return prize;
    }

    public boolean hasSameMatchCount(int matchCount) {
        return matchCount == requiredMatchCount;
    }
}
