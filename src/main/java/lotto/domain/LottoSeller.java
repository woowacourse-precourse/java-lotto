package lotto.domain;

import static lotto.constant.Constant.PRICE;

public class LottoSeller {
    public static final LottoSeller getInstance = new LottoSeller();

    public int getSellPages(int money) {
        return money / PRICE;
    }
}
