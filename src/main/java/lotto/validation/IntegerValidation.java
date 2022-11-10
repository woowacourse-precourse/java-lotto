package lotto.validation;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class IntegerValidation {
    public boolean isNumeric(String userInput, int greaterThan, int smallerThan) {
        if (userInput.length() != userInput.chars()
                .filter(inputChar -> isNumber(inputChar, greaterThan, smallerThan))
                .count()) {
            return false;
        }
        return true;
    }

    private boolean isNumber(int inputChar, int greaterThan, int smallerThan) {
        return greaterThan <= inputChar
                && inputChar <= smallerThan ;
    }

    public boolean isDivideByInteger(int money, int divisor) {
        if ((money % divisor) != 0) {
            return false;
        }
        return true;
    }
}
