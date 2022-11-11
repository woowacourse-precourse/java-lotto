package lotto;

public enum LottoRank {
    FIRST_PLACE(6, false),
    SECOND_PLACE(5, true),
    THIRD_PLACE(5, false),
    FOURTH_PLACE(4, false),
    FIFTH_PLACE(3, false),
    NOTHING(0, false);

    private int hitCount;
    private boolean hitBonus;

    LottoRank(int hitCount, boolean hitBonus) {
        this.hitCount = hitCount;
        this.hitBonus = hitBonus;
    }

    boolean equal(int hitCount, boolean hitBonus) {
        if (this.hitCount == hitCount && hitCount != 5) {
            return true;
        }

        return this.hitCount == hitCount && this.hitBonus == hitBonus;
    }
}
