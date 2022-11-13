package lotto.service;

import java.util.List;
import java.util.regex.Pattern;
import lotto.message.Const;
import lotto.message.ErrorMessage;
import lotto.util.Util;

public class LottoGameService {

    public int buyLottoTickets(final String purchaseAmount) {
        validPurchaseAmount(purchaseAmount);
        int lottoTickets = Integer.parseInt(purchaseAmount) / Const.LOTTO_TICKET_PRICE.getValue();
        return lottoTickets;
    }

    private void validPurchaseAmount(final String purchaseAmount) {
        if (!Pattern.matches("^[0-9]*$", purchaseAmount)) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER.getErrorMessage());
        }

        int value = Integer.parseInt(purchaseAmount);
        if (value % Const.LOTTO_TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_DIVIDE_1000WON.getErrorMessage());
        }
    }

    public List<Integer> pickWinningNumbers(final String winningNumbers) {
        validWinningNumbers(winningNumbers);
        return Util.stringToIntegerList(winningNumbers);
    }

    private void validWinningNumbers(final String numbers) {
        String[] winningNumbers = numbers.split(",");
        for (String number : winningNumbers) {
            if (!Pattern.matches("^[0-9]*$", number)) {
                throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBER_NOT_NUMBER.getErrorMessage());
            }
        }
    }
}
