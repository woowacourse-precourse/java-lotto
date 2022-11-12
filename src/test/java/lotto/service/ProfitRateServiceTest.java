package lotto.service;

import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProfitRateServiceTest {
    @DisplayName("수익률이 소수점 둘째 자리에서 반올림 하는지 테스트")
    @Test
    void checkProfitRateRoundFirstDecimalPlace() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(15000);
        double profitRate = ProfitRateService.calculateRate(purchaseAmount, 10000);
        assertThat(profitRate).isEqualTo(66.7);
    }
}