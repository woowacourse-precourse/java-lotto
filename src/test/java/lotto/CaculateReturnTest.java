package lotto;

import lotto.domain.CalculateReturn;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CaculateReturnTest {
    @Test
    void CalculateReturn_테스트() {
        int winCount = 8;
        LinkedHashMap<String, Integer> winningStats = new LinkedHashMap<>() {{
            put("FIFTH", 1);
            put("FOURTH", 0);
            put("THIRD", 0);
            put("SECOND", 0);
            put("FIRST", 0);
        }};
        String result = "62.5";

        assertThat(result).isEqualTo(new CalculateReturn(winCount, winningStats).getReturnRate());
    }
}