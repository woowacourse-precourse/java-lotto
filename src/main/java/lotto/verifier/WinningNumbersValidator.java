package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbersValidator {

    public List<Integer> askWinningNumbers() throws IllegalArgumentException {
        String input = Console.readLine();

        List<Integer> winningNumbers = validateInput(input);
        ;

        return winningNumbers;
    }

    private List<Integer> validateInput(String input) {
        if (!isCorrectFormat(input)) {
            throw new IllegalArgumentException("\"숫자,숫자,숫자...\" 형식이여야 합니다");
        }

        List<Integer> winningNumbers = transformToWinningNumbers(input);
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("숫자는 총 6개 입력되어야합니다.");
        }
        if (isDuplicated(winningNumbers)) {
            throw new IllegalArgumentException("숫자끼리 중복되지 않아야 합니다.");
        }
        if (isNumbersFrom1To45(winningNumbers)) {
            throw new IllegalArgumentException("숫자는 1부터 45 사이여야합니다.");
        }

        return winningNumbers;
    }

    private boolean isCorrectFormat(String input) {
        String[] numbers = input.split(",");

        for (String number : numbers) {
            if (!isFrom1To45(number)) {
                return false;
            }
        }

        return true;
    }

    private boolean isDuplicated(List<Integer> winningNumbers) {
        return true;
    }

    private boolean isNumbersFrom1To45(List<Integer> winningNumbers) {
        return true;
    }

    private boolean isFrom1To45(String input) {
        String pattern = "[1-9]|[1-4][0-9]";
        return Pattern.matches(pattern, input);
    }

    private List<Integer> transformToWinningNumbers(String input) {
        return null;
    }
}
