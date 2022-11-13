package lotto.controller;

import lotto.domain.Money;
import lotto.utils.ExceptionType;
import lotto.view.Input;
import lotto.view.Output;

public class InputController {

    public Money getMoney() {
        String line = Input.readLine();
        int convertedLine = stringToInt(line);
        return new Money(convertedLine);
    }

    private int stringToInt(String target) {
        validateIsNumber(target);
        return Integer.parseInt(target);
    }

    private void validateIsNumber(String target) throws IllegalArgumentException {
        String numberRegex = "^[0-9]*$";
        if (!target.matches(numberRegex)) {
            Output.printErrorAndExit(ExceptionType.IS_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException(ExceptionType.IS_NOT_NUMBER.getMessage());
        }
    }
}
