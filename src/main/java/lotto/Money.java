package lotto;

public class Money {
    private final int money;

    private Money(String input) {
        int money = validateInt(input);
        validateMoneyOver(money);
        validateMoneyDivison(money);
        this.money = money;
    }

    public static Money newMoneyWithInput(String input) {
        return new Money(input);
    }

    public int getCountByLotto() {
        return money/1_000;
    }

    private static int validateInt(String money) {
        try {
            return Integer.parseInt(money);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수(1~45)만 입력 가능합니다.");
        }
    }

    private void validateMoneyOver(int money) {
        if (money < 1_000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입을 위한 최소 금액은 " + 1_000 + "원 입니다.");
        }
    }

    private void validateMoneyDivison(int money) {
        if (money % 1_000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 " + 1_000 + "원 단위로만 구매할 수 있습니다.");
        }
    }
}
