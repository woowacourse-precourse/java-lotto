package lotto.domain;

public enum Rank {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), NO_LUCK(6);

    private final int rank;
    Rank(int rank) {
        this.rank = rank;
    }

    public static int of(int jackpotCnt, boolean hasBonus) {
        if (jackpotCnt == Lotto.NUMBER_SIZE) {
            return FIRST.rank;
        } else if ((jackpotCnt == Lotto.NUMBER_SIZE - 1) && hasBonus) {
            return SECOND.rank;
        } else if (jackpotCnt == Lotto.NUMBER_SIZE - 1) {
            return THIRD.rank;
        } else if (jackpotCnt == Lotto.NUMBER_SIZE - 2) {
            return FOURTH.rank;
        } else if (jackpotCnt == Lotto.NUMBER_SIZE - 3) {
            return FIFTH.rank;
        }

        return NO_LUCK.rank;
    }
}
