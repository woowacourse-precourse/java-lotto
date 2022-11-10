package lotto.exception;

import java.util.List;

public class WinningNumbersException {

    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final String NUMBER_REGEX = "[0-9]+";

    public static void checkWinningNumbers(String winningNumbersInput) {
        CommonInputException.checkCommonInput(winningNumbersInput, "당첨 번호를");
        List<String> winningNumbers = List.of(winningNumbersInput.split(","));
        checkRightWinningNumbersSize(winningNumbers);
        checkEachWinningNumber(winningNumbers);
    }

    private static void checkRightWinningNumbersSize(List<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자를 입력해주세요.");
        }
    }

    private static void checkEachWinningNumber(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            checkWinningNumberDigit(winningNumber);
        }
    }

    private static void checkWinningNumberDigit(String winningNumber) {
        if (!winningNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자를 입력해주세요.");
        }
    }
}
