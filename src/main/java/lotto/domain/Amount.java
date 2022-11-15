package lotto.domain;

import lotto.utils.Validator;

public class Amount {
    private static final String UNDER_ZERO_AMOUNT = "[ERROR] 금액이 너무 적습니다.";
    private static final String THOUSAND_AMOUNT = "[ERROR] 1000 단위만 입력할 수 있습니다.";
    public static final int LOTTO_AMOUNT = 1000;
    private final int purchaseAmount;

    public Amount(String purchaseAmount) {
        Validator.isOneNumber(purchaseAmount);
        int amount = Integer.parseInt(purchaseAmount);
        checkThousand(amount);
        checkUnderZero(amount);
        this.purchaseAmount = amount;
    }

    private void checkUnderZero(int inputAmount) {
        if (inputAmount <= 0) {
            throw new IllegalArgumentException(UNDER_ZERO_AMOUNT);
        }
    }

    private void checkThousand(int inputAmount) {
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException(THOUSAND_AMOUNT);
        }
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_AMOUNT;
    }
}
