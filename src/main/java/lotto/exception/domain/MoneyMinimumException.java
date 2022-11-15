package lotto.exception.domain;

import lotto.exception.LottoException;

public class MoneyMinimumException extends LottoException {
    private static final String MONEY_MINIMUM_EXCEPTION_MESSAGE = "돈은 %s 이상이어야 합니다.";

    public MoneyMinimumException(long moneyMin) {
        super(String.format(MONEY_MINIMUM_EXCEPTION_MESSAGE, moneyMin));
    }
}
