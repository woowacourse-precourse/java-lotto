package lotto.domain;

import lotto.utils.Constant;

public class Game {
    public Game() {
    }

    public Integer getLottoCount(int amount) {
        return amount / Constant.PURCHASE_AMOUNT_UNIT;
    }
}
