package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public int calculateLottoAmount() {
        return this.money / 1000;
    }
}
