package lotto;

import lotto.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static final int[] REWARD_LEVEL = {5000, 50000, 1500000, 30000000, 2000000000};

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 로또_3등_당첨이_5개일_때의_상금계산_test() {

        int reward = calculator.getReward(REWARD_LEVEL, new int[] {5, 0, 0, 0, 0});
        assertThat(reward).isEqualTo(25000);
    }

    @Test
    void 구입금액은_5000원_상금이_25000원일_때의_수익률계산_test() {

        String rate = calculator.getRate(5000, 25000);
        assertThat(rate).isEqualTo("500.0");
    }
}
