package lotto.domain;

public enum PrizeStatistic {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_PLUS_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchingNumbers;
    private final boolean bonus;
    private final long prizeAmount;
    private int count;

    PrizeStatistic(int matchingNumbers, boolean bonus, long prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.bonus = bonus;
        this.prizeAmount = prizeAmount;
        this.count = 0;
    }

    public static long getPrizeAmount(int numberOfMatches, boolean doesBonusMatch) {
        long prizeAmount = 0;
        for (PrizeStatistic prize : values()) {
            if (prize.matchingNumbers == numberOfMatches && prize.bonus == doesBonusMatch){
                prize.increaseCount();
                prizeAmount = prize.prizeAmount;
                return prizeAmount;
            }
        }
        return prizeAmount;
    }

    private void increaseCount() {
        this.count++;
    }
}
