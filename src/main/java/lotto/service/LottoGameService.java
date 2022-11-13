package lotto.service;

import java.util.regex.Pattern;
import lotto.message.ErrorMessage;

public class LottoGameService {

    public int inputMoney(final String money) {
        validMoney(money);
        return 0;
    }

    private void validMoney(final String money) {
        if (!Pattern.matches("^[0-9]*$", money)) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER.getErrorMessage());
        }

        Integer value = Integer.valueOf(money);
        if (value / 1000 != 0) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_DIVIDE_1000WON.getErrorMessage());
        }
    }
}
