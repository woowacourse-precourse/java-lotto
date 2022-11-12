package lotto;

public class MoneyValidator {
    private static boolean isNumeric(String moneyInput) {
        for (int index = 0; index < moneyInput.length(); index++) {
            if (!Character.isDigit(moneyInput.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    public static void validateMoney(String moneyInput) {
        if (!isNumeric((moneyInput))) {
            throw new IllegalArgumentException();
        }
    }
}
