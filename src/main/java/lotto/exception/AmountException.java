package lotto.exception;

public class AmountException {

    public static void validateAmount(String input) {

    }

    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private static boolean isAccurateUnit(String input) {
        if(Integer.parseInt(input) % 1000 != 0) return false;
        return true;
    }
}
