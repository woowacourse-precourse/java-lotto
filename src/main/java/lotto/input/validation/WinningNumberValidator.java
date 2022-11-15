package lotto.input.validation;

import lotto.input.validation.code.WinningNumberValidationCode;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberValidator {
    public WinningNumberValidationCode validateWinningNumber(List<String> tokens) {
        if (!hasExactlySixTokens(tokens)) {
            return WinningNumberValidationCode.HAS_MORE_OR_LESS_THAN_SIX_TOKENS;
        }
        if (!hasNumberElementsOnly(tokens) || !hasValidNumberFormatElementsOnly(tokens)) {
            return WinningNumberValidationCode.HAS_ILLEGAL_CHARACTERS;
        }
        List<Integer> numbers = tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
        if (!hasNoDuplicateNumber(numbers)) {
            return WinningNumberValidationCode.DUPLICATE_NUMBER;
        }
        if (!isEveryNumberInRange(numbers)) {
            return WinningNumberValidationCode.NUMBER_OUT_OF_RANGE;
        }
        return WinningNumberValidationCode.VALID;
    }

    private boolean hasExactlySixTokens(List<String> tokens) {
        return tokens.size() == 6;
    }

    private boolean hasNumberElementsOnly(List<String> tokens) {
        return tokens.stream().filter(this::isNumericExpression).count() == tokens.size();
    }

    private boolean isNumericExpression(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private boolean hasValidNumberFormatElementsOnly(List<String> tokens) {
        return tokens.stream().filter(this::isValidNumberFormat).count() == tokens.size();
    }

    private boolean isValidNumberFormat(String string) {
        return string.charAt(0) >= '1' && string.charAt(0) <= '9';
    }

    private boolean hasNoDuplicateNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    private boolean isEveryNumberInRange(List<Integer> numbers) {
        return numbers.stream().filter(num -> num >= 1 && num <= 45).count() == numbers.size();
    }
}
