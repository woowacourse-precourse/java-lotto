package lotto.input;

import java.util.List;
import lotto.exception.LottoException;
import lotto.ui.Message;

public class InputValidator {
    private static final int LOTTO_PRICE = 1_000;

    public void validationInputLength(String input) {
        if (input.length() == 0) {
            throw new LottoException(Message.NO_INPUT_ERROR);
        }
    }

    public void validationZeroAmount(int amount) {
        if (amount == 0) {
            throw new LottoException(Message.ZERO_PRICE_ERROR);
        }
    }

    public void validationAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new LottoException(Message.NO_THOUSAND_PRICE_ERROR);
        }
    }

}
