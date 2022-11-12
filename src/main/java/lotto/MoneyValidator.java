package lotto;

public class MoneyValidator {
    private static int COST_OF_LOTTO = 1000;

    private static boolean isNumeric(String moneyInput) {
        for (int index = 0; index < moneyInput.length(); index++) {
            if (!Character.isDigit(moneyInput.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDividedByConstOfLotto(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if (money == 0 || money % COST_OF_LOTTO != 0) {
            return false;
        }
        return true;
    }

    public static void validateMoney(String moneyInput) {
        if (!isNumeric((moneyInput))) {
            throw new IllegalArgumentException();
        }
        if (!isDividedByConstOfLotto(moneyInput)) {
            throw new IllegalArgumentException();
        }
    }
}
