package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityCalculatorTest {

    @Test
    void calculateProperQuantity() {
        int quantity = QuantityCalculator.calculateProperQuantity(14000);
        Assertions.assertThat(quantity).isEqualTo(14);
    }

//    @Test  -> 예외를 도메인에서 throw하는 것이 맞는가??
//    void indivisibleByThousandErrorThrownTest() {
//        Assertions.assertThatThrownBy(() -> QuantityCalculator.calculateProperQuantity(14001))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR]");
//    }
}