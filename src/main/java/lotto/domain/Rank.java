package lotto.domain;

public enum Rank {
    FIRST(1, Lotto.NUMBER_SIZE, false),
    SECOND(2, Lotto.NUMBER_SIZE - 1, true),
    THIRD(3, Lotto.NUMBER_SIZE - 1, false),
    FOURTH(4, Lotto.NUMBER_SIZE - 2, false),
    FIFTH(5, Lotto.NUMBER_SIZE - 3, false);

    private static final int NO_LUCK = -1;
    private final int rank;
    private final int jackpotCnt;
    private final boolean hasBonus;

    Rank(int rank, int jackpotCnt, boolean hasBonus) {
        this.rank = rank;
        this.jackpotCnt = jackpotCnt;
        this.hasBonus = hasBonus;
    }

    public static int of(int jackpotCnt, boolean hasBonus) {
        for (Rank instance : Rank.values()) {
            if (jackpotCnt == SECOND.jackpotCnt && hasBonus) {
                return SECOND.rank;
            } else if (jackpotCnt == THIRD.jackpotCnt) {
                return THIRD.rank;
            }

            if (jackpotCnt == instance.jackpotCnt) {
                return instance.rank;
            }
        }

        return NO_LUCK;
    }
}
