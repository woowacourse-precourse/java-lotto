package lotto.domain;

public class LottoSeller {
    private static final int PRICE = 1_000;
    public int getSellPages(int money) {
        return money/PRICE;
    }
}
