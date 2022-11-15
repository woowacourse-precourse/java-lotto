package lotto.domain.user;

import lotto.common.Constant;
import lotto.exception.InputException;

public class Purchase {
    private static final int PERCENTAGE = 100;
    private final int amount;

    private Purchase(int amount) {
        isDividedByLottoAmount(amount);
        this.amount = amount;
    }

    public static Purchase create(String amount) {
        hasDigitsOnly(amount);
        return new Purchase(Integer.parseInt(amount));
    }

    private static void hasDigitsOnly(String purchaseAmount) {
        if (!purchaseAmount.matches(Constant.REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIGIT.message());
        }
    }

    private static void isDividedByLottoAmount(int purchaseAmount) {
        if (purchaseAmount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }

    public int getLottoPublishCount() {
        return amount / Constant.LOTTO_PRICE;
    }

    public double findLottoYield(int winAmount) {
        double quotient = (double) winAmount / (double) amount;
        return quotient * PERCENTAGE;
    }
}
