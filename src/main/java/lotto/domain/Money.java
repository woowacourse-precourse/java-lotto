package lotto.domain;

import lotto.constant.LottoConstants;

public final class Money {
    private static final String NEGATIVE_MESSAGE = "돈에는 양수가 들어와야 합니다";
    private static final String MULTIPLE_MESSAGE =
            "돈에는 " + LottoConstants.LOTTO_PRICE.value() + "의 배수가 들어와야 합니다";
    private static final int unit = 1000;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (!isPositive(amount)) {
            throw new IllegalArgumentException(NEGATIVE_MESSAGE);
        }
        if (!isMultipleOfUnit(amount)) {
            throw new IllegalArgumentException(MULTIPLE_MESSAGE);
        }
    }

    private boolean isPositive(int amount) {
        return amount > 0;
    }

    private boolean isMultipleOfUnit(int amount) {
        return amount % unit == 0;
    }

    public int ableToBuy() {
        return amount / unit;
    }
}
