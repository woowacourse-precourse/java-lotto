package lotto.domain;

import lotto.util.errorMessage.ErrorMessage;

public class LottoPieces {

    public final int pieces;

    public LottoPieces(int money) {
        validateMoney(money);
        this.pieces = calculatePieces(money);
    }

    private static int calculatePieces(int money) {
        int pieces = money / 1000;
        return pieces;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_UNIT_ERROR);
        }
    }
}
