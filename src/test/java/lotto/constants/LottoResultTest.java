package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void getPrizeByCorrectCount_3_5000() {
        assertThat((LottoResult.getPrizeByCorrectCount(3))).isEqualTo(5_000);
    }
}