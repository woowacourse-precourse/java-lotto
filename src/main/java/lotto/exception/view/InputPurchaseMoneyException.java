package lotto.exception.view;

import lotto.exception.LottoException;

public class InputPurchaseMoneyException extends LottoException {
    private static final String LOTTO_INPUT_PURCHASE_MONEY_EXCEPTION_MESSAGE = "로또 구입 금액 입력이 잘못됐습니다.";

    public InputPurchaseMoneyException() {
        super(LOTTO_INPUT_PURCHASE_MONEY_EXCEPTION_MESSAGE);
    }
}
