package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class YieldTest {

    @DisplayName("수익률 = (이익/구매금액)*100 이다.")
    @Test
    void createYieldRateTest() {
        double purchasePrice = 123000;
        double profits = 12300;
        double expected = 10;
        Yield yield = new Yield(purchasePrice, profits);
        assertThat(yield.getYieldRate()).isEqualTo(expected);
    }
}