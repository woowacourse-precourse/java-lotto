package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetRateOfReturnTest {

    @Test
    void calculateRate() {
        GetRateOfReturn testcase = new GetRateOfReturn();
        long [] result = {0, 0, 1, 0, 0, 0, 0};
        long money = 8000;
        assertThat(testcase.calculateRate(result, money)).isEqualTo(62.5);
    }
}