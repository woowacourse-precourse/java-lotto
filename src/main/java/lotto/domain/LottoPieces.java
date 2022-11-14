package lotto.domain;

import lotto.util.errorMessage.ErrorMessage;

public class LottoPieces {

    private static final int MIN_UNIT = 1000;

    public final int pieces;

    public LottoPieces(Money money) {
        this.pieces = calculatePieces(money);
    }

    public static int calculatePieces(Money money) {
        int pieces = getQuotient(money);
        return pieces;
    }

    private static int getQuotient(Money money) {
        return money.getMoney() / MIN_UNIT;
    }
}
