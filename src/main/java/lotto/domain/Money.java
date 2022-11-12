package lotto.domain;

public class Money {
    private static final String ERROR_UNIT_COUNT = "[ERROR] 1000원 단위로만 입력 가능합니다";

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public static boolean validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_UNIT_COUNT);
        }
        return true;
    }

    public int getMoney() {
        return this.money;
    }
}
