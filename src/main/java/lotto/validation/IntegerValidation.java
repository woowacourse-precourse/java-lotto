package lotto.validation;


public class IntegerValidation {

    public static boolean isNumeric(String userInput, int asciiGreaterThan, int asciiSmallerThan) {
        return userInput.length() == userInput.chars()
                .filter(inputChar -> isNumber(inputChar, asciiGreaterThan, asciiSmallerThan))
                .count();
    }

    public static boolean isDivideByInteger(String money, int divisor) {
        return (Integer.parseInt(money) % divisor) == 0;
    }

    public static boolean isBetween(int value, int valueGreaterThan, int valueSmallerThan) {
        return valueGreaterThan <= value
                && value <= valueSmallerThan;
    }

    private static boolean isNumber(int inputChar, int asciiGreaterThan, int asciiSmallerThan) {
        return asciiGreaterThan <= inputChar
                && inputChar <= asciiSmallerThan;
    }

}
