package lotto.enums;

public enum RankCount {
    FIRST_PRIZE_COUNT(6), SECOND_PRIZE_COUNT(5), SECOND_PRIZE_BONUS(1), THIRD_PRIZE_COUNT(5), FOURTH_PRIZE_COUNT(4), FIFTH_PRIZE_COUNT(3);

    private int count;

    RankCount(int numberCount) {
        this.count = numberCount;
    }

    public int getNumberCount() {
        return count;
    }
}
