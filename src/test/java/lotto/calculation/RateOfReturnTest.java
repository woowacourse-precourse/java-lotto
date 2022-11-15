package lotto.calculation;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RateOfReturnTest {

    @Test
    void calculateTest() {
        Map<String, Integer> statistiscs = new HashMap<>();
        for (int rank = 1; rank < 6; rank++) {
            statistiscs.put(rank + "등", 0);
        }//

        statistiscs.put("5등", 1);
        int amount = 8000;
        assertThat(RateOfReturn.calculate(statistiscs, amount)).isEqualTo(62.5);

        amount = 9000;
        assertThat(RateOfReturn.calculate(statistiscs, amount)).isEqualTo(55.6);
    }//calculateTest
}//end class
