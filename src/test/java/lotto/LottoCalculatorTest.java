package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    void compare() {
        LottoCalculator lottoCalculator = new LottoCalculator();
        int input = lottoCalculator.compare(Arrays.asList(1, 2, 3, 4, 5, 10), Arrays.asList(1, 2, 3, 4, 5, 30), 6);
        int result = 2;

        assertThat(input).isEqualTo(result);
    }

    @Test
    void addRankCount() {
        LottoCalculator lottoCalculator = new LottoCalculator();
        int input = 1;
        int input2 = 4;
        lottoCalculator.addRankCount(input);
        lottoCalculator.addRankCount(input2);
        lottoCalculator.addRankCount(input2);

        assertThat(lottoCalculator.getRankCount()).isEqualTo(Arrays.asList(0, 1, 0, 0, 2));
    }
}