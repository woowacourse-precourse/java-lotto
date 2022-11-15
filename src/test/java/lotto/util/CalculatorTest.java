package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CalculatorTest {
    @DisplayName("당첨 결과는 크기가 5인 Map을 반환한다.")
    @Test
    void calculateResultTest() {
        Map<Result, Integer> resultCounts = Calculator.calculateResult(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), new HashSet<>(List.of(1, 2, 3, 4, 5, 6)), 7);
        Assertions.assertThat(resultCounts).size().isEqualTo(5);
    }

    @DisplayName("당첨 금액은 음수가 아니다.")
    @Test
    void calculateEarnTest() {
        int earn = Calculator.calculateEarn(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), new HashSet<>(List.of(1, 2, 3, 4, 5, 6)), 7);
        Assertions.assertThat(earn).isNotNegative();
    }

    @DisplayName("수익률은 음수가 아니다.")
    @Test
    void calculateYieldTest_음수가아님() {
        double yield = Calculator.calculateYield(1000, 1000);
        Assertions.assertThat(yield).isNotNegative();
    }

    @DisplayName("수익률은 (당첨 금액 / 사용금액) * 100으로 계산된 결과이다.")
    @Test
    void calculateYieldTest_계산결과() {
        double yield = Calculator.calculateYield(8000, 5000);
        Assertions.assertThat(yield).isEqualTo(62.5);
    }
}
