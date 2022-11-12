package lotto;

public class MoneyValidator extends Validator {
    private static int COST_OF_LOTTO = 1000;
    private static String NEMERIC_ERROR_MESSAGE = "[ERROR] 입력된 값이 숫자가 아닙니다";
    private static String DIVIDED_ERROR_MESSAGE = String.format("[ERROR] 입력된 값이 %s원 단위가 아닙니다", COST_OF_LOTTO);

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

    public static void validate(String moneyInput) {
        if (!isNumeric((moneyInput))) {
            throw new IllegalArgumentException(NEMERIC_ERROR_MESSAGE);
        }
        if (!isDividedByConstOfLotto(moneyInput)) {
            throw new IllegalArgumentException(DIVIDED_ERROR_MESSAGE);
        }
    }
}
