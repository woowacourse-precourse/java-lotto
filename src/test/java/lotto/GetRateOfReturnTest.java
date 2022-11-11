package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetRateOfReturnTest {

    @Test
    void calculateRate() {
        GetRateOfReturn testcase = new GetRateOfReturn();
        int [] result = {0, 0, 1, 0, 0, 0, 0};
        int money = 8000;
        assertThat(testcase.calculateRate(result, money)).isEqualTo(62.5);
    }
}