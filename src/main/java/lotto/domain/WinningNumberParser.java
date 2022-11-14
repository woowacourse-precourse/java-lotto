package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberParser {

    private static final String INVALID_FORMAT_OF_WINNING_NUMBER = "올바른 당첨 번호 포맷이 아닙니다.";

    List<Integer> winningNumbers(String formattedNumber) {
        validateWinningNumberFormat(formattedNumber);

        String[] formattedNumbers = formattedNumber.split(",");
        return Arrays.stream(formattedNumbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void validateWinningNumberFormat(String winningNumber) {
        final String REGEX_FOR_WINNING_NUMBER = "^(\\d+,){5}\\d+$";
        if (!winningNumber.matches(REGEX_FOR_WINNING_NUMBER)) {
            throw new IllegalArgumentException(INVALID_FORMAT_OF_WINNING_NUMBER);
        }
    }
}
