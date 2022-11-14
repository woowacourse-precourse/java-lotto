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

    @DisplayName("수익률 소수점 두번째 자리에서 반올림되는 계산 테스트")
    @Test
    void 수익률_반올림_계산_테스트_1() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.FIFTH, 2);
        float expected = 142.9f;

        assertThat(Calculator.getYield(7000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("소수점 첫번째 자리까지의 수익률 계산 테스트")
    @Test
    void 수익률_반올림_계산_테스트_2() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.FIFTH, 1);
        float expected = 250.0f;

        assertThat(Calculator.getYield(2000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 1000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_3() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.FOURTH, 1);
        float expected = 250.0f;

        assertThat(Calculator.getYield(2000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 10,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_4() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.THIRD, 1);
        float expected = 75_000.0f;

        assertThat(Calculator.getYield(2000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 100,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_5() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.SECOND, 1);
        float expected = 300_000.0f;

        assertThat(Calculator.getYield(10_000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 1,000,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_6() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.SECOND, 1);
        float expected = 3_000_000.0f;

        assertThat(Calculator.getYield(1_000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 10,000,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_7() {
        EnumMap<RankNumber, Integer> resultStatistics = Checker.initializeResultStatistics();
        resultStatistics.put(RankNumber.FIRST, 1);
        float expected = 3_000_000.0f;

        assertThat(Calculator.getYield(10_000, resultStatistics))
                .isEqualTo(expected);
    }
}
