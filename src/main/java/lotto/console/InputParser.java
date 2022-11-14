package lotto.console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class InputParser {

    private static final String STANDARD_WINNING_NUMBERS_REGEX = "^(\\d+,){5}\\d+$";
    public static final String NUMBER_REGEX = "\\d+";

    private InputParser() {
    }

    static List<Integer> parseStandardWinningNumbers(String number) {
        validateParsedStandardWinningNumbers(number);

        return Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateParsedStandardWinningNumbers(String number) {
        if (!number.matches(STANDARD_WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException("‘,’로 구분해서 숫자들을 입력해주세요.");
        }
    }

    static int parseNumber(String number) {
        validateParsedNumber(number);

        return Integer.parseInt(number);
    }

    private static void validateParsedNumber(String number) {
        if (!number.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
