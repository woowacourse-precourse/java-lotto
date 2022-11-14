package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class WinningNumberValidator {

    public List<Integer> askWinningNumbers() {
        String input = Console.readLine();

        validateInput(input);

        List<Integer> winningNumbers = getWinningNumbers(input);

        return null;
    }

    private boolean validateInput(String input) {
        return true;
    }

    private boolean isCorrectFormat(String input) {
        return true;
    }

    private boolean isLengthEleven(String input) {
        return true;
    }

    private boolean isDuplicated(String input) {
        return true;
    }

    private List<Integer> getWinningNumbers(String input) {
        return null;
    }
}
