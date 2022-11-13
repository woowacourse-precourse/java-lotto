package lotto;

public class MoneyInputException {
    public static void moneyTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
    }

    public static void moneyChangeError(int money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000 단위여야 합니다.");
    }
}
