package lotto.service;

import java.util.regex.Pattern;
import lotto.message.Const;
import lotto.message.ErrorMessage;

public class LottoGameService {

    public int inputMoney(final String money) {
        validMoney(money);
        int lottoTickets = Integer.parseInt(money) / Const.LOTTO_TICKET_PRICE.getValue();
        return lottoTickets;
    }

    private void validMoney(final String money) {
        if (!Pattern.matches("^[0-9]*$", money)) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER.getErrorMessage());
        }

        int value = Integer.parseInt(money);
        if (value % Const.LOTTO_TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_DIVIDE_1000WON.getErrorMessage());
        }
    }
}
