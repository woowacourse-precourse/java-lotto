package lotto.domain;

import lotto.constant.LottoConstants;

/**
 * 돈을 담당하는 클래스
 */
public final class Money {
    private static final String NEGATIVE_MESSAGE = "돈에는 양수가 들어와야 합니다";
    private static final String MULTIPLE_MESSAGE =
            "돈에는 " + LottoConstants.LOTTO_PRICE + "의 배수가 들어와야 합니다";
    private static final int unit = 1000;
    private final long amount;

    /**
     * 얼마인지를 숫자를 입력받는다
     *
     * @param amount 돈의 양을 다루는 숫자
     */
    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        if (!isPositive(amount)) {
            throw new IllegalArgumentException(NEGATIVE_MESSAGE);
        }
        if (!isMultipleOfUnit(amount)) {
            throw new IllegalArgumentException(MULTIPLE_MESSAGE);
        }
    }

    private boolean isPositive(long amount) {
        return amount > 0L;
    }

    private boolean isMultipleOfUnit(long amount) {
        return amount % unit == 0;
    }

    /**
     * 로또를 얼마나 구매할 수 있는지를 계산해준다
     *
     * @return 실제 구매 가능한 로또의 수를 나타내는 정수값
     */
    public long ableToBuy() {
        return amount / unit;
    }
}
