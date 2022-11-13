package lotto.controller;

import lotto.domain.Money;
import lotto.utils.ExceptionType;
import lotto.view.Input;

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
            throw new IllegalArgumentException(ExceptionType.IS_NOT_NUMBER.getMessage());
        }
    }
}
