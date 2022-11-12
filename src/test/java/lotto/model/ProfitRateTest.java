package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProfitRateTest {
    @DisplayName("수익률이 너무 큰경우 지수(exponent)가 제거 되는지 테스트")
    @Test
    void checkProfitRateByToString() {
        ProfitRate profitRate = new ProfitRate(1000000000000.0);
        assertThat(profitRate.toString()).isEqualTo("1,000,000,000,000.0");
    }
}