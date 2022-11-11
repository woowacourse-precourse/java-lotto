package lotto.validation;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class IntegerValidation {
    public static boolean isNumeric(String userInput, IntConstant asciiGreaterThan, IntConstant asciiSmallerThan) {
        return userInput.length() == userInput.chars()
                .filter(inputChar -> isNumber(inputChar, asciiGreaterThan, asciiSmallerThan))
                .count();
    }

    public static boolean isDivideByInteger(String money, IntConstant divisor) {
        return (Integer.parseInt(money) % divisor.getValue()) == 0;
    }

    public static boolean isBetween(String userInput, IntConstant valueGreaterThan, IntConstant valueSmallerThan) {
        return valueGreaterThan.getValue() <= Integer.parseInt(userInput)
                && Integer.parseInt(userInput) <= valueSmallerThan.getValue();
    }

    private static boolean isNumber(int inputChar, IntConstant asciiGreaterThan, IntConstant asciiSmallerThan) {
        return asciiGreaterThan.getValue() <= inputChar
                && inputChar <= asciiSmallerThan.getValue() ;
    }
}
