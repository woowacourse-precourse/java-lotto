package lotto.ui;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public class InputValidator {
    private static final String INPUT_MONEY_PATTERN = "^[1-9]+[0-9]{3,8}+$";
    private static final String INPUT_WINNING_NUMBERS_PATTERN = "^[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*$";
    private static final String INPUT_BONUS_NUMBER_PATTERN = "^[0-9]*$";
    private static final int MAXIMUM_DIGITS_OF_INPUT_NUMBER = 9;

    public static void validateInputMoney(String moneyRaw) {
        boolean isMatch = Pattern.matches(INPUT_MONEY_PATTERN, moneyRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_MONEY);
    }

    public static void validateInputWinningNumbers(String numbersRaw) {
        boolean isMatch = Pattern.matches(INPUT_WINNING_NUMBERS_PATTERN, numbersRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_WINNING_NUMBERS);
    }

    public static void validateInputBonusNumber(String bonusNumberRaw) {
        validateIsMatchInputBonusWithPattern(bonusNumberRaw);
        validateIsOver9digits(bonusNumberRaw);
    }

    private static void validateIsMatchInputBonusWithPattern(String bonusNumberRaw) {
        boolean isMatch = Pattern.matches(INPUT_BONUS_NUMBER_PATTERN, bonusNumberRaw);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_BONUS_NUMBER);
    }

    private static void validateIsOver9digits(String numberRaw) {
        if (numberRaw.length() > MAXIMUM_DIGITS_OF_INPUT_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_TOO_BIG_BONUS_NUMBER);
        }
    }
}
