package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.view.IOProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MarginCalculatorTest {
    @Test
    @DisplayName("당첨결과에 따른 손익률을 정확히 계산하는 지 테스트")
    void margin_calculator_test() {
        MarginCalculator calculator = new MarginCalculator();
        List<Integer> winningInfo = new ArrayList<>(List.of(0, 0, 0, 0, 0, 1));

        assertThat(calculator.getMarginRatio(winningInfo, 8))
                .isEqualTo(62.5);
    }
}
