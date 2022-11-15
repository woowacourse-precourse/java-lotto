package lotto.rule;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class LottoRangeTest {

    @Test
    void isOutOfRange_true() {
        assertThat(LottoRange.isOutOfRange(100)).isEqualTo(true);
    }

    @Test
    void isOutOfRange_false() {
        assertThat(LottoRange.isOutOfRange(5)).isEqualTo(false);
    }
}