package lotto;

import enumCollections.RankNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @DisplayName("수익률 계산")
    @Test
    void winSecondPrizeTest() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.FIFTH, 1);
        float expected = 62.5f;

        assertThat(Calculator.getYield(8000, resultStatistics))
                .isEqualTo(expected);
    }
}
