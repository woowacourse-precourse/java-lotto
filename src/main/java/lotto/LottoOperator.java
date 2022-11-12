package lotto;

import java.util.Arrays;

public enum LottoOperator {
    NO_LUCK(0, 0),
    THIRD(3, 10),
    FOUR(4, 10),
    FIVE(5, 10),
    SIX(6, 10);

    private final int count;
    private final int winningAmount;

    LottoOperator(int count, int winningAmount) {
        this.count = count;
        this.winningAmount = winningAmount;
    }

    public static LottoOperator find(int count) {
        return Arrays.stream(values())
                .filter(rank ->  rank.matchCount(count))
                .findFirst()
                .orElse(NO_LUCK);
    }

    private boolean matchCount(int count) {
        return this.count == count;
    }
}
