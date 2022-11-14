package lotto.Domain.Statistic;

public enum PrizeRankIndex {
    THREE(0),
    FOUR(1),
    FIVE(2),
    SIX_YES_BONUS(3),
    SIX_NO_BONUS(4);
    private final int index;

    PrizeRankIndex (int index) {
        this.index = index;
    }

    public int getNum() {
        return index;
    }
}
