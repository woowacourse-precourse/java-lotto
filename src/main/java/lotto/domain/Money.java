package lotto.domain;

public class Money {

    public static final int PRICE_OF_ONE_TIME_LOTTO = 1000;
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfLottoGame() {
        return this.amount / PRICE_OF_ONE_TIME_LOTTO;
    }
}
