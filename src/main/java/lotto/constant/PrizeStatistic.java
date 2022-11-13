package lotto.constant;

public enum PrizeStatistic {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_PLUS_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchingNumbers;
    private final boolean bonus;
    private final long prizeAmount;

    PrizeStatistic(int matchingNumbers, boolean bonus, long prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.bonus = bonus;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingNumbers() {
        return this.matchingNumbers;
    }

    public boolean geBonus() {
        return this.bonus;
    }

    public long getPrizeAmount() {
        return this.prizeAmount;
    }


}
