package lotto.utils;

public class Validation {

    public static boolean validatePurchaseAmount(String input) {
        if (!isMultipleOfThousand(input)) {
            throwException("1000원 단위의 금액을 입력해주세요.");
        }
        if (!isNumeric(input)) {
            throwException("숫자를 입력해주세요.");
        }
        return true;
    }


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
