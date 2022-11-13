package lotto.exception;

public class AmountException {

    public static void validateAmount(String input) {

    }

    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
