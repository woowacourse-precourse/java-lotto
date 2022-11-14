package lotto.domain;

public class Purchase {

    private static final int LOTTO_PRICE = 1_000;
    private int amount;
    private int count;

    public Purchase(int amount) {
        validate(amount);
        this.amount = amount;
        this.count = amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
