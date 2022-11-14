package lotto.ui;

public class Validator {
    public static boolean isNumber(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액 입력입니다.");
        }
        return true;
    }
}
