package lotto.validate;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import lotto.util.Converter;

public class ValidateWinningNumbers extends Validate {
    private static final int NUMBER_LENGTH = 6;

    public static List<Integer> validate(String winningNumbers) throws IllegalArgumentException {
        validateIsNullOrEmpty(winningNumbers);
        validateSyntax(winningNumbers);
        validateLength(winningNumbers);
        validateIsNumbers(winningNumbers);
        validateRangeNumbers(winningNumbers);
        validateDuplicate(winningNumbers);

        return Converter.stringToIntList(winningNumbers, ",");
    }

    private static void validateIsNumbers(String winningNumbers) throws IllegalArgumentException {
        for (String element : Converter.stringToStringArray(winningNumbers, ",")) {
            validateIsNumber(element);
        }
    }

    private static void validateSyntax(String winningNumbers) throws IllegalArgumentException {
        try {
            winningNumbers.split(",");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 번호를 쉼표(,)로 구분지어 입력하셔야 합니다.");
        }
    }

    private static void validateLength(String winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.split(",").length != NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NUMBER_LENGTH + "개의 번호를 입력하셔야 합니다.");
        }
    }

    private static void validateRangeNumbers(String winningNumbers) throws IllegalArgumentException {
        String[] splitedWinningNumbers = winningNumbers.split(",");
        for (String element : splitedWinningNumbers) {
            validateRange(Integer.parseInt(element));
        }
    }

    private static void validateRange(int number) throws IllegalArgumentException {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE +
                    MIN_NUMBER + "과 " + MAX_NUMBER + "사이의 숫자를 입력하셔야 합니다.");
        }
    }

    private static void validateDuplicate(String winningNumbers) throws IllegalArgumentException {
        List<String> containingWinningNumbers = Arrays.asList(winningNumbers.split(","));

        for (String number : containingWinningNumbers) {
            if (containingWinningNumbers.indexOf(number) !=
                    containingWinningNumbers.lastIndexOf(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 서로 다른 숫자를 입력하셔야 합니다.");
            }
        }
    }
}
