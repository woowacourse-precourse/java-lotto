package lotto.domain;

public class Customer {
    private final Money money;
    private static final int LOTTO_PRICE = 1000;

    public Customer(int money) {
        this.money = new Money(money);
    }

    public int getBuyLottoQuantity() {
        return (money.getMoney() / LOTTO_PRICE);
    }

    public Money getMoney() {
        return money;
    }
}
