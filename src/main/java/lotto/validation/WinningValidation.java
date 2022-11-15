package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.enums.NumbersType;
import lotto.validation.enums.ErrorMessage;
import lotto.validation.enums.RegEx;

public class WinningValidation extends IllegalArgumentException {
    private ErrorMessage message;
    private RegEx regEx;
    private List<String> winningNumbers;

    public WinningValidation() {
    }

    public void throwError(String msg) {
        throw new IllegalArgumentException(msg);
    }

    public void isValidWinning(String input) {
        isBlank(input);
        isNumberAndComma(input);
        isCorrectRange(input);
        isCorrectWinningSize(input);
        isDuplicate(input);
    }

    public void isValidBonus(String input, List<Integer> winningNumbers) {
        isBlank(input);
        isNumber(input);
        isCorrectRange(input);
        isContainWinning(input, winningNumbers);
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
        winningNumbers = Arrays.asList(input.split(","));
        for (String number : winningNumbers) {
            if (Integer.parseInt(number) < NumbersType.START_INCLUSIVE.getValue()
                    || Integer.parseInt(number) > NumbersType.END_INCLUSIVE.getValue()) {
                message = ErrorMessage.valueOf("CORRECT_RANGE_WINNING_EXCEPTION");
                throwError(message.getMessage());
            }
        }
    }

    public void isCorrectWinningSize(String input) {
        winningNumbers = Arrays.asList(input.split(","));
        if (winningNumbers.size() != NumbersType.NUMBERS_SIZE.getValue()) {
            message = ErrorMessage.valueOf("CORRECT_SIZE_WINNING_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isDuplicate(String input) {
        winningNumbers = Arrays.asList(input.split(","));
        if (new HashSet<>(winningNumbers).size() != NumbersType.NUMBERS_SIZE.getValue()) {
            message = ErrorMessage.valueOf("DUPLICATE_WINNING_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isNumber(String input) {
        regEx = RegEx.valueOf("BONUS_INPUT_REG_EX");
        if (!Pattern.matches(regEx.getRegEx(), input)) {
            message = ErrorMessage.valueOf("NUMBER_BONUS_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isContainWinning(String input, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(input))) {
            message = ErrorMessage.valueOf("CONTAIN_BONUS_EXCEPTION");
            throwError(message.getMessage());
        }
    }
}