package lotto.domain;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;
    private final int price;

    public LottoPurchase(final int price) {
        validatePrice(price);
        this.price = price;
    }

    public int lottoQuantity() {
        return price / LOTTO_PRICE;
    }

    private void validatePrice(final int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR]Lotto purchase price must be more than 1000 won.");
        }
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]Buy the lotto by 1000 won.");
        }
    }

}
