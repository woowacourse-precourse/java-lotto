package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

public class WinningNumber {
    private final InputValidation inputValidation = new InputValidation();

    public void inputWinningNumbers() {
        String numbers = Console.readLine();
        inputValidation.validateWinningNumbers(numbers);
    }
}
