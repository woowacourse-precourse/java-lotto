package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class WinningValidation extends IllegalArgumentException {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int WINNING_SIZE = 6;

    private ErrorMessage message;
    private RegEx regEx;
    private List<String> winning;

    public WinningValidation() {
    }

    public void throwError(String msg) {
        throw new IllegalArgumentException(msg);
    }

    public void isValidWinning() {
    }

    public void isValidBonus() {
    }

    public void isBlank(String input) {
        if (input.isBlank()) {
            message = ErrorMessage.valueOf("BLANK_WINNING_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isNumberAndComma(String input) {
        regEx = RegEx.valueOf("WINNING_INPUT_REG_EX");
        if (!Pattern.matches(regEx.getRegEx(), input)) {
            message = ErrorMessage.valueOf(("NUMBER_COMMA_WINNING_EXCEPTION"));
            throwError(message.getMessage());
        }
    }

    public void isCorrectRange(String input) {
        winning = Arrays.asList(input.split(","));
        for (String number : winning) {
            if (Integer.parseInt(number) < START_INCLUSIVE || Integer.parseInt(number) > END_INCLUSIVE) {
                message = ErrorMessage.valueOf("CORRECT_RANGE_WINNING_EXCEPTION");
                throwError(message.getMessage());
            }
        }
    }

    public void isCorrectWinningSize(String input) {
        winning = Arrays.asList(input.split(","));
        if (winning.size() != WINNING_SIZE) {
            message = ErrorMessage.valueOf("CORRECT_SIZE_WINNING_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isDuplicate(String input) {
        winning = Arrays.asList(input.split(","));
        if (new HashSet<>(winning).size() != WINNING_SIZE) {
            message = ErrorMessage.valueOf("DUPLICATE_WINNING_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isNumber(String input) {
    }

    public void isCorrectBonusSize(String input) {
    }

    public void isContainWinning(String input, List<Integer> winnings) {
    }
}