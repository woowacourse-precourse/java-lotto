package lotto.domain;

import constants.LottoGame;

public class LottoAmount {

    private final int amount;

    public LottoAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public void validate(int amount) {
        if (amount % LottoGame.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getLottoCount() {
        return amount / LottoGame.LOTTO_PRICE;
    }
}
