package lotto.model;

public class LottoCount {
    private static final String UNIT = "1000";
    private final int lottoCount;

    public LottoCount(Money money) {
        lottoCount = money.calculateLottoCount(new Money(UNIT));
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
