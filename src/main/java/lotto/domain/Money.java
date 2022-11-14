package lotto.domain;

public class Money {
    private static final int MIN_MONEY = 1000;
    private final String money;

    public Money(String money) {
        this.money = money;
    }

    private boolean isNotNumeric(String money) {
        return !money.chars().allMatch(Character::isDigit);
    }

    private boolean isInvalidMoney(int money) {
        return (MIN_MONEY > money) || (money % MIN_MONEY) != 0;
    }
}
