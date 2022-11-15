package lotto.model;

public class LottoCount {
    private static final String DEFAULT_UNIT = "1000";
    private final int lottoCount;

    public LottoCount(Money money) {
        lottoCount = money.calculateLottoCount(new Money(DEFAULT_UNIT));
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
