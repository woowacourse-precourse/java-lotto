package lotto.domain;

public enum LottoRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    MISS(0, false, 0);

    private final int count;
    private final boolean isSameBonus;
    private final int amount;

    LottoRank(int count, boolean isSameBonus, int amount) {
        this.count = count;
        this.isSameBonus = isSameBonus;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public boolean isSameBonus() {
        return isSameBonus;
    }

    public int getAmount() {
        return amount;
    }
}
