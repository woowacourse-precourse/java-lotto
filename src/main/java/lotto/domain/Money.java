package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private int price;

    public Money(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPrice() {
        return price;
    }

    public int lottoCount() {
        return (int) price / 1000;
    }
}
