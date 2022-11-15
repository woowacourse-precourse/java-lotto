package lotto.domain;

import constants.ExceptionMessage;
import constants.LottoGame;
import lotto.presentation.view.LottoExceptionPrinter;

public class LottoAmount {

    private final int amount;

    public LottoAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public void validate(int amount) {
        if (amount % LottoGame.LOTTO_PRICE != 0) {
            LottoExceptionPrinter.throwIllegalLottoAmount();
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_LOTTO_AMOUNT);
        }
    }

    public int getLottoCount() {
        return amount / LottoGame.LOTTO_PRICE;
    }

    public int getLottoAmount() {
        return this.amount;
    }
}
