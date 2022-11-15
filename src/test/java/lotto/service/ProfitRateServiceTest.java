package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class ProfitRateServiceTest {
    @DisplayName("수익률이 소수점 둘째 자리에서 반올림 하는지 테스트")
    @Test
    void checkProfitRateRoundFirstDecimalPlace() {
        BigDecimal profitRate = ProfitRateService.calculateRate(15000, 10000);
        assertThat(profitRate.toString()).isEqualTo("66.7");
    }
}