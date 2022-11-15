package lotto.lotto;

public class Buy {
    private static final int LOTTO_PRICE = 1_000;
    public int lottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }
}
