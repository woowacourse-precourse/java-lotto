package lotto.domain;

public class Wallet {

    private static final int TICKET_PRICE = 1000;

    private final int money;

    public Wallet(int money) {
        this.money = money;
    }

    public int calculate() {
        return money / TICKET_PRICE;
    }
}
