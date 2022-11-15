package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class QuantityCalculatorTest {
    @Test
    void calculateProperQuantity() {
        int quantity = QuantityCalculator.calculateProperQuantity(14000);
        Assertions.assertThat(quantity).isEqualTo(14);
    }
}