package lotto.domain;

public enum Winner {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private int count;
    private int prize;
    private boolean bonusNum;

    Winner(int count, int prize, boolean bonusNum) {
        this.count = count;
        this.prize = prize;
        this.bonusNum = bonusNum;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusNum() {
        return bonusNum;
    }

    public static Winner getWinner(int winningCount, boolean isBonus) {
        Winner winner = Winner.findBy(winningCount, isBonus);

        if (winner.equals(null)) {
            throw new IllegalArgumentException();
        }
        return winner;
    }

    private static Winner findBy(int winningCount, boolean isBonus) {
        for (Winner winner : values()) {
            if (winner.count == winningCount && winner.bonusNum == isBonus) {
                return winner;
            }
        }
        return null;
    }
}
