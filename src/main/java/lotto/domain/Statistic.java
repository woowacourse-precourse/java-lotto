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

    public static Statistic findStatistic(int matchingNumber, boolean bonusFlag) {
        if (matchingNumber == 3) return THREE;
        if (matchingNumber == 4) return FOUR;
        if (matchingNumber == 5 && bonusFlag) return BONUS;
        if (matchingNumber == 5) return FIVE;
        if (matchingNumber == 6) return SIX;
        return null;
    }
}
