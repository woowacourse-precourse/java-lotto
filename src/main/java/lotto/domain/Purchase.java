package lotto.domain;

public class Purchase {

    private static final int LOTTO_PRICE = 1_000;

    private final int amount;
    private final int count;

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

    public int getCount() {
        return count;
    }

}
