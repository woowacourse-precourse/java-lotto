package lotto.verifiable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckProfitTest {
    @DisplayName("수익률 계산")
    @Test
    void calcBenefit() {
        Long prizeMoney = 5000L;
        Integer prizeCount = 8;
        double v = ((double) prizeMoney / (prizeCount * 1000)) * 100;
        assertThat(v).isEqualTo(62.5);
    }
}