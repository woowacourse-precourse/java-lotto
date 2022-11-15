package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningHistoryTest {
    @Test
    void 수익률_계산() {
        assertThat(Math.round((double) 5 / 8 * 1000) / 10.0).isEqualTo(62.5);
    }
}