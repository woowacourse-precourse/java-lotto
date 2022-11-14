package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRateTest {

    @DisplayName("계산식이 맞는가?")
    @Test
    void getRateTest() {
        long totalPrizeMoney = 234000;
        long payment = 40200;
        double result = (double) totalPrizeMoney / (double) payment * 100.0;
        LottoRate rateTest = new LottoRate(totalPrizeMoney, payment);
        assertThat(rateTest.getRate()).isEqualTo(result);
    }
}