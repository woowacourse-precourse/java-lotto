package lotto.exception;

import java.util.List;

public class WinningNumbersException {

    private static final int WINNING_NUMBERS_SIZE = 6;

    public static void checkWinningNumbers(String winningNumbersInput) {
        CommonInputException.checkCommonInput(winningNumbersInput, "당첨 번호를");
        List<String> winningNumbers = List.of(winningNumbersInput.split(","));
        checkRightWinningNumbersSize(winningNumbers);
    }

    private static void checkRightWinningNumbersSize(List<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자를 입력해주세요.");
        }
    }
}
