package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningHistoryTest {
    @Test
    void 수익률_계산() {
        assertThat(Math.round((double) 5 / 8 * 1000) / 10.0).isEqualTo(62.5);
    }
}