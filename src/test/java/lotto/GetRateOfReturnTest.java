package lotto;

import static org.assertj.core.api.Assertions.*;
import lotto.domain.GetRateOfReturn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetRateOfReturnTest {
    @DisplayName("수익률 계산 하는 test")
    @Test
    void calculateRate() {
        GetRateOfReturn testcase = new GetRateOfReturn();
        long [] result = {0, 0, 0, 1, 0, 0, 0, 0};
        long money = 8000;
        assertThat(testcase.calculateRate(result, money)).isEqualTo("62.5");
    }
}