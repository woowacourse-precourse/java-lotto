package lotto.ui;

public class Validator {
    public static boolean isNumber(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        return true;
    }

    public static boolean isNumber(String input) {
        try {
            int money = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
        return true;
    }
}
