package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;

public class MarginCalculatorTest {
    @Test
    @DisplayName("당첨결과에 따른 손익률을 정확히 계산하는 가?")
    void margin_calculator_test() {
        LinkedHashMap<String, Integer> winningInfo = new LinkedHashMap<>();
        winningInfo.put("WINNING_ONE", 0);
        winningInfo.put("WINNING_TWO", 0);
        winningInfo.put("WINNING_THREE", 0);
        winningInfo.put("WINNING_FOUR", 0);
        winningInfo.put("WINNING_FIVE", 1);

        assertThat(MarginCalculator.getMarginRatio(winningInfo, 8))
                .isEqualTo(62.5);
    }
}
