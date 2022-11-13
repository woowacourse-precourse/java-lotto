package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoReference;
import org.junit.jupiter.api.Test;

class LottoReferenceTest {

    @Test
    void getPrizeByCorrectCount_3_5000() {
        assertThat((LottoReference.getPrizeByCorrectCount(3))).isEqualTo(5_000);
    }
}