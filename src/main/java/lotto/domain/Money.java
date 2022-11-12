package lotto.domain;

public class Money {
    public static final int MINIMUM_AMOUNT = 1000;
    public static final int MAXIMUM_AMOUNT = 100_000;
    public static final int UNIT_AMOUNT = 1000;
    private final int amount;

    public Money(int amount) {
        validateMinimumAmount(amount);
        validateMaximumAmount(amount);
        validateUnitAmount(amount);
        this.amount = amount;
    }

    private static void validateMinimumAmount(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상 구매해야 합니다.");
        }
    }

    private static void validateMaximumAmount(int money) {
        if (money > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 한도는 최대 10만원까지입니다.");
        }
    }

    private static void validateUnitAmount(int money) {
        if (money % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }
}
