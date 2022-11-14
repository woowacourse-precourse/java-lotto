package lotto.domain;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getAmount() {
        return money / Config.LOTTO_PRICE;
    }
}
