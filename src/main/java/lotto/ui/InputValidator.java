package lotto.ui;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public class InputValidator {
    private static final String INPUT_MONEY_PATTERN = "^[1-9]+[0-9]{3,8}+$";
    private static final String INPUT_WINNING_NUMBERS_PATTERN = "^[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*$";
    private static final String INPUT_BONUS_NUMBER_PATTERN = "^[0-9]*$";
    private static final int MAXIMUM_DIGITS = 9;

    public static void checkInputMoney(String inputMoneyRaw) {
        boolean isMatch = Pattern.matches(INPUT_MONEY_PATTERN, inputMoneyRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_MONEY);
    }

    public static void checkInputWinningNumbers(String numbersRaw) {
        boolean isMatch = Pattern.matches(INPUT_WINNING_NUMBERS_PATTERN, numbersRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_WINNING_NUMBERS);
    }

    public static void checkInputBonusNumber(String bonusNumberRaw) {
        checkIsMatchInputBonusWithPattern(bonusNumberRaw);
        checkIsOver9digits(bonusNumberRaw);
    }

    private static void checkIsMatchInputBonusWithPattern(String bonusNumberRaw) {
        boolean isMatch = Pattern.matches(INPUT_BONUS_NUMBER_PATTERN, bonusNumberRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_BONUS_NUMBER);
    }

    private static void checkIsOver9digits(String bonusNumberRaw) {
        if (bonusNumberRaw.length() > MAXIMUM_DIGITS) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_TOO_BIG_BONUS_NUMBER);
        }
    }
}
