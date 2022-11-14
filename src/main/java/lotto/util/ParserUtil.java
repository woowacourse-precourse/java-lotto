package lotto.util;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ParserUtil {

    final static int MIN_PURCHASE_AMOUNT = 1000;
    final static int SIZE_OF_LOTTO_NUMBER = 6;

    public static void parsePurchaseAmountInput(String input) {
        if (!ValidationUtil.validateIsDigit(input)) {
            throw new IllegalArgumentException();
        }
        int purchaseAmount = Integer.parseInt(input);

        if (!ValidationUtil.validateMinNumber(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
        if (!ValidationUtil.validateRemainder(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
    }

    public static void parseWinningNumbersInput(String winningNumInput) {
        if (!ValidationUtil.validateIsDigitAndComma(winningNumInput)) {
            throw new IllegalArgumentException();
        }
    }

    public static void parseBonusNumberInput(String bonusNumInput) {
        if (!ValidationUtil.validateIsDigit(bonusNumInput)) {
            throw new IllegalArgumentException();
        }
        int bonusNum = Integer.parseInt(bonusNumInput);
        if (!ValidationUtil.validateIsInRange(bonusNum)) {
            throw new IllegalArgumentException();
        }
    }

}
