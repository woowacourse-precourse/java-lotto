package lotto;

public enum LottoRank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000),
    NOTHING(0, false, 0);

    private final int hitCount;
    private final boolean hitBonus;
    private final int prizeMoney;

    LottoRank(int hitCount, boolean hitBonus, int prizeMoney) {
        this.hitCount = hitCount;
        this.hitBonus = hitBonus;
        this.prizeMoney = prizeMoney;
    }

    public boolean equal(int hitCount, boolean hitBonus) {
        if (this.hitCount == hitCount && hitCount != 5) {
            return true;
        }

        return this.hitCount == hitCount && this.hitBonus == hitBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
