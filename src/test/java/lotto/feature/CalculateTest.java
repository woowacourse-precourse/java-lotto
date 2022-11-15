package lotto.feature;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Calculate;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    Calculate calculate = new Calculate();

    @Test
    void test_calculateRateOfProfit() {
        int buyAmount = 5;
        long winning = 55000;

        assertThat(calculate.calculateRateOfProfit(buyAmount, winning)).isEqualTo(1100.0);
    }

}
