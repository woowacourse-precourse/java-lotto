package lotto.domain;

import org.junit.jupiter.api.BeforeEach;

class ProfitTest {

    private static final int PURCHASE_AMOUNT = 8000;
    private static final String RATE = String.valueOf(62.5);

    private final PrizeCount prizeCount = new PrizeCount();

    private Profit profit;

    @BeforeEach
    void setUp() {
        prizeCount.addPrizeCount(Prize.FIFTH);
        profit = new Profit(prizeCount);
        profit.calculate(PURCHASE_AMOUNT);
    }

}