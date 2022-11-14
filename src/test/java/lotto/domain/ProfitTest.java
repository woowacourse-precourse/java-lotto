package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProfitTest {
    @DisplayName("수익률을 정상적으로 구하는지 확인한다.")
    @Test
    void calculateRate_정상동작() {
        Double input = Profit.calculateRate(8000, 5000);
        assertThat(input).isEqualTo(62.5);
    }

}