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

    public static int bonusException(String input) throws IllegalArgumentException {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }

        int bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonus;
    }
}
