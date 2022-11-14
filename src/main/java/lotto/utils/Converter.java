package lotto.utils;

import static lotto.utils.ErrorMessage.BONUS_NOT_NUMBER_ERROR;
import static lotto.utils.ErrorMessage.INPUT_EMPTY_ERROR;
import static lotto.utils.ErrorMessage.MONEY_LIMIT_ERROR;
import static lotto.utils.ErrorMessage.MONEY_NUMBER_ERROR;
import static lotto.utils.ErrorMessage.SEPARATOR_ERROR;

import java.util.List;

public class Converter {
    public static int changeToMoney(String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(INPUT_EMPTY_ERROR.toString());
        }
        if (InputValidator.isNotNumber(input)) {
            throw new IllegalArgumentException(MONEY_NUMBER_ERROR.toString());
        }
        if (InputValidator.isOutOfLimit(input)) {
            throw new IllegalArgumentException(MONEY_LIMIT_ERROR.toString());
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> changeToWinningNumber(String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(INPUT_EMPTY_ERROR.toString());
        }
        if (InputValidator.isNotCorrectSeparator(input)) {
            throw new IllegalArgumentException(SEPARATOR_ERROR.toString());
        }
        return WinningNumberSplit.splitWinningNumber(input);
    }

    public static int changeToBonusNumber(String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(INPUT_EMPTY_ERROR.toString());
        }
        if (InputValidator.isNotNumber(input)) {
            throw new IllegalArgumentException(BONUS_NOT_NUMBER_ERROR.toString());
        }
        return Integer.parseInt(input);
    }
}