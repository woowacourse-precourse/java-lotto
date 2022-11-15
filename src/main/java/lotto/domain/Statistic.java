package lotto.domain;

public enum Statistic {

    THREE(3, 5_000), FOUR(4, 50_000), FIVE(5, 1_500_000),
    BONUS(5, 30_000_000), SIX(6, 2_000_000_000);

    private final int matchingNumber;
    private final int prize;

    Statistic(int matchingNumber, int prize) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrize() {
        return prize;
    }
}
