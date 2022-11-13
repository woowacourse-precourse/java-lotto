package lotto.domain;

public class PlayerLottoAmount {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private final int amount;

    public PlayerLottoAmount(int amount) {

        this.amount = amount;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_MIN_AMOUNT;
    }

}
