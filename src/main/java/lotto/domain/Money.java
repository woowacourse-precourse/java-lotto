package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int purchase() {
        return this.money / LOTTO_PRICE;
    }
}
