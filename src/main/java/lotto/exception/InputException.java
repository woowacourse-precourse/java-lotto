package lotto.exception;

public class InputException {
    public static int inputMoneyException(String input) throws IllegalArgumentException {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력 가능합니다.");
        }

        int money = Integer.parseInt(input);
        if (money % 1000 != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력받을 수 있습니다.");
        }
        return money;
    }
}
