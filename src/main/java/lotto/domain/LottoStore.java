package lotto.domain;

public class LottoStore {

    private static final int A_LOTTO_PRICE = 1000;

    public int getLottoAmount(int lottoPurchaseMoney) {
        return lottoPurchaseMoney / A_LOTTO_PRICE;
    }

}
