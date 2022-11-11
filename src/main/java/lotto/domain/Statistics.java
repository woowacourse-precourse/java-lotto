package lotto.domain;


import lotto.exception.InputException;

public class Statistics {

    public static final String REG_XP_DIGITS = "^[0-9]+$";
    private final int purchaseAmount;

    public Statistics(String purchaseAmount) {
        hasDigitsOnly(purchaseAmount);
        int money = Integer.parseInt(purchaseAmount);
        isDividedByLottoAmount(money);
        this.purchaseAmount = money;
    }

    private void hasDigitsOnly(String purchaseAmount) {
        if (!purchaseAmount.matches(REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.INPUT_NOT_DIGIT.message());
        }
    }

    private void isDividedByLottoAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(InputException.INPUT_MUST_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }
}
