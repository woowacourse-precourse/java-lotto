package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void 로또_개수_테스트() {
        Calculator calculator = new Calculator();
        int count = calculator.getLottoCount(14000);

        assertThat(count).isEqualTo(14);
    }
}