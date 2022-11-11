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

    @Test
    void 수익률_계산_테스트() {
        Calculator calculator = new Calculator();
        double answer = calculator.calculateYield(Rank.FIFTH, 8000);
        assertThat(answer).isEqualTo(62.5);
    }
    @Test
    void 수익률_소수점_둘째짜리_반올림_테스트() {
        Calculator calculator = new Calculator();
        double answer = calculator.calculateYield(Rank.FIFTH, 9000);
        assertThat(answer).isEqualTo(55.56);
    }
}