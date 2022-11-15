package lotto.domain.winningElements;

import java.util.HashSet;
import java.util.List;

public class WinningNumbersValidator {
    private static final String EMPTY_WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호가 입력되지 않았습니다.";
    private static final String NOT_CONTAINS_COMMA_ERROR_MESSAGE = "[ERROR] 입력된 값이 형식에 맞지 않습니다. (입력된 값에 콤마(,)가 존재하지 않습니다.)";
    private static final String CONSECUTIVE_COMMAS_ERROR_MESSAGE = "[ERROR] 입력된 값이 형식에 맞지 않습니다. (콤마(,)가 연속으로 입력되었습니다.)";
    private static final String FIRST_AND_LAST_ARE_NOT_NUMBER = "[ERROR] 입력된 값이 형식에 맞지 않습니다. (첫 번째 또는 마지막 값이 숫자가 아닙니다.)";
    private static final String ALL_CHARACTERS_ARE_NOT_DIGIT_EXCEPT_COMMA_ERROR_MESSAGE = "[ERROR] 입력된 값이 형식에 맞지 않습니다. (콤마(,)를 제외한 값 중에 숫자가 아닌 문자가 있습니다.)";
    private static final String NOT_SIX_ELEMENTS_ERROR_MESSAGE = "[ERROR] 입력된 당첨 번호의 개수가 6개로 이루어져 있지 않습니다.";
    private static final String LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호 범위인 1 ~ 45에 속하지 않는 수가 입력되었습니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 입력된 당첨 번호에 중복된 수가 있습니다.";

    private static final String COMMA_DELIMITER = ",";
    private static final int LIMIT_SIZE = 6;
    private static final int RANGE_FIRST_VALUE = 1;
    private static final int RANGE_LAST_VALUE = 45;

    public static void validateBeforeParse(String winningNumbers) {
        validateEmptyWinningNumbers(winningNumbers);

        validateContainsComma(winningNumbers);

        validateConsecutiveCommas(winningNumbers);

        validateFirstAndLastAreNumber(winningNumbers);

        validateAllCharactersAreDigitExceptComma(winningNumbers);
    }

    public static void validateAfterParse(List<Integer> winningNumbers) {
        validateSixElements(winningNumbers);

        validateLottoNumberRange(winningNumbers);

        validateDuplicateNumber(winningNumbers);
    }

    public static void validateEmptyWinningNumbers(String winningNumbers) {
        if (winningNumbers.isEmpty() || winningNumbers.equals("") || winningNumbers == null) {
            throw new IllegalArgumentException(EMPTY_WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    public static void validateContainsComma(String winningNumbers) {
        if (!winningNumbers.contains(COMMA_DELIMITER)) {
            throw new IllegalArgumentException(NOT_CONTAINS_COMMA_ERROR_MESSAGE);
        }
    }

    public static void validateConsecutiveCommas(String winningNumbers) {
        for (int i = 0; i < winningNumbers.length() - 1; i++) {
            String firstLetter = String.valueOf(winningNumbers.charAt(i));
            String secondLetter = String.valueOf(winningNumbers.charAt(i + 1));

            if (firstLetter.equals(secondLetter) && firstLetter.equals(COMMA_DELIMITER)) {
                throw new IllegalArgumentException(CONSECUTIVE_COMMAS_ERROR_MESSAGE);
            }
        }
    }

    public static void validateFirstAndLastAreNumber(String winningNumbers) {
        char last = winningNumbers.charAt(winningNumbers.length() - 1);

        if (last == ',') {
            throw new IllegalArgumentException(FIRST_AND_LAST_ARE_NOT_NUMBER);
        }

        String[] numbers = winningNumbers.split(",");

        if (!checkLettersAreDigit(numbers[0]) || !checkLettersAreDigit(numbers[numbers.length - 1])) {
            throw new IllegalArgumentException(FIRST_AND_LAST_ARE_NOT_NUMBER);
        }
    }

    public static void validateAllCharactersAreDigitExceptComma(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");

        for (String number : numbers) {
            if (!checkLettersAreDigit(number)) {
                throw new IllegalArgumentException(ALL_CHARACTERS_ARE_NOT_DIGIT_EXCEPT_COMMA_ERROR_MESSAGE);
            }
        }
    }

    private static boolean checkLettersAreDigit(String letters) {
        try {
            Long.parseLong(letters);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void validateSixElements(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LIMIT_SIZE) {
            throw new IllegalArgumentException(NOT_SIX_ELEMENTS_ERROR_MESSAGE);
        }
    }

    public static void validateLottoNumberRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < RANGE_FIRST_VALUE || number > RANGE_LAST_VALUE) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateDuplicateNumber(List<Integer> winningNumbers) {
        HashSet<Integer> numericalSeparator = new HashSet<>();

        for (Integer number : winningNumbers) {
            if (!numericalSeparator.contains(number)) {
                numericalSeparator.add(number);
                continue;
            }

            if (numericalSeparator.contains(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
            }
        }
    }
}
