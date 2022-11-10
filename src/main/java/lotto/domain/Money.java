package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        isLowerThan1000(money);
        isDivideInto1000(money);
    }

    private void isLowerThan1000(int money) {
        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    private void isDivideInto1000(int money) {
        if(money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
