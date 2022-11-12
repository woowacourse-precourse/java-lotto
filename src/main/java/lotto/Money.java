package lotto;

public class Money {
    private static final int MINIMUM_MONEY_VALUE = 1000;
    private static final int MONEY_UNIT = 1000;
    private static final String LOTTO_MONEY_IS_UNDER_MINIMUM_MONEY_VALUE = "[ERROR] 로또 구입 금액이 1,000원 이하입니다.";
    private static final String LOTTO_MONEY_IS_NOT_DIVIDED_BY_MONEY_VALUE = "[ERROR] 로또 구입 금액이 1000원 이하입니다.";

    private final int money;

    public Money(int money) {
        validateMoneyValue(money);
        this.money = money;
    }

    private void validateMoneyValue(int money) {
        validateMoneySize(money);
        validateMoneyUnit(money);
    }

    private void validateMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_IS_NOT_DIVIDED_BY_MONEY_VALUE);
        }
    }

    private void validateMoneySize(int money) {
        if (money < MINIMUM_MONEY_VALUE) {
            throw new IllegalArgumentException(LOTTO_MONEY_IS_UNDER_MINIMUM_MONEY_VALUE);
        }
    }
}