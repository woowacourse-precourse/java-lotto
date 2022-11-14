package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class WinningNumbersValidator {

    public List<Integer> askWinningNumbers() throws IllegalArgumentException{
        String input = Console.readLine();

        validateInput(input);

        List<Integer> winningNumbers = getWinningNumbers(input);

        return null;
    }

    private void validateInput(String input) {
        if(input.length() != 11) {
            throw new IllegalArgumentException("11글자여야 합니다");
        }
        if(!isCorrectFormat(input)) {
            throw new IllegalArgumentException("\"숫자,숫자,숫자...\" 형식이여야 합니다");
        }
        if(isDuplicated(input)) {
            throw new IllegalArgumentException("숫자끼리 중복되지 않아야 합니다.");
        }
    }

    private boolean isCorrectFormat(String input) {
        return true;
    }

    private boolean isDuplicated(String input) {
        return true;
    }

    private List<Integer> getWinningNumbers(String input) {
        return null;
    }
}
