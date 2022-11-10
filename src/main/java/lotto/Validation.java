package lotto;

public class Validation {
    public static boolean isValidUnit(int amount) {
        return amount % 1000 == 0;
    }

    public static boolean isValidRange(int amount) {
        return amount > 0;
    }

    public static boolean existOnlyNumber(String amount) {
        try {
            Integer.parseInt(amount);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
