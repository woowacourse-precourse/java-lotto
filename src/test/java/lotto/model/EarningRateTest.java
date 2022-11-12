package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarningRateTest {

    @Test
    void computeEarningRate() {
        EarningRate earningRate = new EarningRate(8000);
        double rate = earningRate.computeEarningRate(5000);
        Assertions.assertThat(rate).isEqualTo(62.5);
    }
}