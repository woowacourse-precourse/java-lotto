package lotto.validation;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class IntegerValidation {
    public boolean isNumeric(String userInput, int greaterThan, int smallerThan) {
        return userInput.length() == userInput.chars()
                .filter(inputChar -> isNumber(inputChar, greaterThan, smallerThan))
                .count();
    }

    public boolean isDivideByInteger(int money, int divisor) {
        return (money % divisor) == 0;
    }

    public boolean isBetween(String userInput, int greaterThan, int smallerThan) {
        return greaterThan <= Integer.parseInt(userInput) && Integer.parseInt(userInput) <= smallerThan;
    }

    private boolean isNumber(int inputChar, int greaterThan, int smallerThan) {
        return greaterThan <= inputChar
                && inputChar <= smallerThan ;
    }
}
