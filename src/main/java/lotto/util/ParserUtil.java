package lotto.util;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ParserUtil {

    final static int SIZE_OF_LOTTO_NUMBER = 6;

    public static int parsePurchaseAmountInput(String purchaseAmountInput) {
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);

        if (!ValidationUtil.validatePositiveNum(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
        if (!ValidationUtil.validateRemainder(purchaseAmount)) {
            throw new IllegalArgumentException();
        }

        return purchaseAmount;
    }

    public static void parseWinningNumbersInput(String winningNumsInput) {
        if (!ValidationUtil.isDigitAndComma(winningNumsInput)) {
            throw new IllegalArgumentException();
        }
    }

}
