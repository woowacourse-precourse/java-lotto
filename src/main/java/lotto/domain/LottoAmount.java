package lotto.domain;

import constants.LottoGame;

public class LottoAmount {

    private final int amount;

    public LottoAmount(int amount) {
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / LottoGame.LOTTO_PRICE;
    }
}
