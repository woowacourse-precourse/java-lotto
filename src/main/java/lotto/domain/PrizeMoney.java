package lotto.domain;

public enum PrizeMoney {
    THREE(3, 5_000, 0),
    FOUR(4, 50_000, 0),
    FIVE(5, 1_500_000, 0),
    BONUS(5, 30_000_000, 0),
    SIX(6, 2_000_000_000, 0);

    private final int matchingNumbers;
    private final int prize;
    private int count;

    PrizeMoney(int matchingNumbers, int prize, int count) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.count = count;
    }

    public static void getMatchingNumbersCount(int numberOfMatch, boolean bonusNumber) {
        if (numberOfMatch == THREE.matchingNumbers) {
            THREE.count++;
        }
        if (numberOfMatch == FOUR.matchingNumbers) {
            FOUR.count++;
        }
        if (numberOfMatch == FIVE.matchingNumbers && !bonusNumber) {
            FIVE.count++;
        }
        if (numberOfMatch == BONUS.matchingNumbers && bonusNumber) {
            BONUS.count++;
        }
        if (numberOfMatch == SIX.matchingNumbers) {
            SIX.count++;
        }
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
