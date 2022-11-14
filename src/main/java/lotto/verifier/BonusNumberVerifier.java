package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNumberVerifier {

    public int askBonusNumber() throws IllegalArgumentException {
        String input = Console.readLine();

        validateInput(input);

        return Integer.parseInt(input);
    }

    private boolean validateInput(String input) {
        return true;
    }

    private boolean isDigit(String input) {
        return true;
    }

    private boolean isLengthOne(String input) {
        return true;
    }

    private boolean isDuplicatedWithWinningNumber(String input) {
        return true;
    }
}
