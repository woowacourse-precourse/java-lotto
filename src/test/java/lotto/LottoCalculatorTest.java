package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    void compare() {
        LottoCalculator lottoCalculator = new LottoCalculator();
        int input = lottoCalculator.compare(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 15, 25, 30), 45);
        int result = 0;

        assertThat(input).isEqualTo(result);
    }
}