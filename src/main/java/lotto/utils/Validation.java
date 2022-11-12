package lotto.utils;

public class Validation {

    public static boolean validate;


    public static boolean isMultipleOfThousand(String input) {
        return Parser.convertStringToInt(input) % 1000 == 0 ;
    }
    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
    public static boolean isNumeric(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }
    public static boolean isValidCommas(String input) {

        return true;
    }
    public static boolean isValidRange(int input) {

        return true;
    }
    public static boolean isUnique(int input) {

        return true;
    }
    public static boolean isValidLength(int input) {

        return true;
    }
}
