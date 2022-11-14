package lotto.domain;

public class LottoAmount {
    private static final int MIN_COST = 1000;
    private static final double DECIMAL = 1.0;

    private final int amount;

    public LottoAmount(final int amount) {
        this.amount = amount;
    }
}
