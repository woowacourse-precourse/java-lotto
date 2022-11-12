package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitTest {

    private static final int PURCHASE_AMOUNT = 8000;
    private static final String RATE = String.valueOf(62.5);

    private final PrizeCount prizeCount = new PrizeCount();

    private Profit profit;

    @BeforeEach
    void setUp() {
        prizeCount.addPrizeCount(Prize.FIFTH);
        profit = new Profit(prizeCount);
        profit.calculate();
        profit.setRate(PURCHASE_AMOUNT);
    }

    @Test
    void getRate() {
        assertThat(profit.getRate()).isEqualTo(RATE);
    }
}