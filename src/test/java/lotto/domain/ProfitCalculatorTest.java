package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfitCalculatorTest {
    @DisplayName("수익률을 계산하여 소수점 둘째자리에서 반올림하여 리턴한다.")
    @Test
    void 수익률_계산() {
        int pay = 8000;
        int profit = 5000;
        assertThat(ProfitCalculator.getInstance.profitPercent(pay, profit)).isEqualTo("62.5");
    }
}
