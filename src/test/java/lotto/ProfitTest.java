package lotto;

import lotto.model.Profit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProfitTest {
    @DisplayName("수익률 = 획득한 금액 / 사용한 금액 * 100으로 정의되며 소수 둘째자리에서 반올림한다.")
    @Test
    void testProfitValue() {
        Profit profit = new Profit(5000, 8000);
        assertThat(profit.getProfitValue()).isEqualTo(62.5);
        profit = new Profit(1000, 3000);
        assertThat(profit.getProfitValue()).isEqualTo(33.33);
        profit = new Profit(0, 0);
        assertThat(profit.getProfitValue()).isEqualTo(0);
    }
}
