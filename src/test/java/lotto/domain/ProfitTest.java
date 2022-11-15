package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitTest {

    private static final int PURCHASE_AMOUNT = 8000;
    private static final String RATE = String.valueOf(62.5);

    private final PrizeCount prizeCount = new PrizeCount();

    private Profit profit;

    @BeforeEach
    void setUp() {
        prizeCount.add(Prize.FIFTH);
        profit = new Profit(prizeCount, PURCHASE_AMOUNT);
        profit.calculate();
    }

    @Test
    void testToString() {
        String message = "총 수익률은 " + RATE + "%" + "입니다.";
        assertThat(profit.toString()).isEqualTo(message);
    }

}