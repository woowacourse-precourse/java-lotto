package lotto.domain;

public class Result {
    private static final int SECOND_PRIZE_MATCH_COUNT = 5;

    private int matchCount;
    private boolean isBonus;

    public void increaseMatchCount() {
        matchCount++;
    }

    public void matchBonus() {
        isBonus = true;
    }

    public boolean isProperPrize(Prize prize) {
        if (prize.getMatchCount() == SECOND_PRIZE_MATCH_COUNT) {
            return matchCount == prize.getMatchCount() && isBonus == prize.isBonus();
        }
        return matchCount == prize.getMatchCount();
    }

    public boolean isFiveHit() {
        return matchCount == SECOND_PRIZE_MATCH_COUNT;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
