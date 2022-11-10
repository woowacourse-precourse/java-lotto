package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersException {

    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final int MAX_WINNING_NUMBER = 45;
    private static final int MIN_WINNING_NUMBER = 1;

    public static void checkWinningNumbers(String winningNumbersInput) {
        CommonInputException.checkCommonInput(winningNumbersInput, "당첨 번호를");
        List<String> winningNumbers = List.of(winningNumbersInput.split(","));
        checkRightWinningNumbersSize(winningNumbers);
        checkEachWinningNumber(winningNumbers);
        checkUniqueWinningNumbers(new HashSet<>(winningNumbers));
    }

    public static void checkRightWinningNumbersSize(List<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자를 입력해주세요.");
        }
    }

    public static void checkUniqueWinningNumbers(Set<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다. 확인 후 중복되지 않은 번호를 입력해주세요.");
        }
    }

    public static void checkEachWinningNumber(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            CommonInputException.checkHasBlankInInput(winningNumber, "당첨 번호를");
            checkWinningNumberDigit(winningNumber);
            checkWinningNumberRange(Integer.parseInt(winningNumber));
        }
    }

    public static void checkWinningNumberDigit(String winningNumber) {
        if (!winningNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자를 입력해주세요.");
        }
    }

    public static void checkWinningNumberRange(Integer winningNumber) {
        if (winningNumber < MIN_WINNING_NUMBER || winningNumber > MAX_WINNING_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자를 입력해주세요.");
        }
    }
}
