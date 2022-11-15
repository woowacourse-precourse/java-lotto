package lotto;

public class NumberOfLotto {
    private final int number;

    public NumberOfLotto(Money money) {
        this.number = computeNumberOfLotto(money.getMoney());
    }

    private int computeNumberOfLotto(int money) {
        final int LOTTO_SELLING_PRICE = 1000;

        return money / LOTTO_SELLING_PRICE;
    }

    public int getNumberOfLotto() {
        return this.number;
    }
}
