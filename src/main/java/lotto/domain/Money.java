package lotto.domain;

public class Money {
    private static final CanValidate<Integer> validator = new MoneyValidator();
    private final int money;

    public Money(int money) {
        validator.validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Money of(int money) {
        return new Money(money);
    }
}
