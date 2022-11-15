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
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                1, 0, 0, 0, 0
        );
        double expected = 2.5E7;
        assertThat(Calculator.getYield(8000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 소수점 두번째 자리에서 반올림되는 계산 테스트")
    @Test
    void 수익률_반올림_계산_테스트_1() {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                0, 0, 0, 0, 2
        );
        double expected = 142.9;
        assertThat(Calculator.getYield(7000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("소수점 첫번째 자리까지의 수익률 계산 테스트")
    @Test
    void 수익률_반올림_계산_테스트_2() {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                0, 0, 0, 0, 1
        );
        double expected = 250.0;
        assertThat(Calculator.getYield(2000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 1000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_3() {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                0, 0, 0, 1, 0
        );
        double expected = 2500.0;
        assertThat(Calculator.getYield(2000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 10,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_4() {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                0, 0, 1, 0, 0
        );
        float expected = 75_000.0f;
        assertThat(Calculator.getYield(2000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 100,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_5() {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                0, 1, 0, 0, 0
        );
        double expected = 300_000.0f;
        assertThat(Calculator.getYield(10_000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 1,000,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_6() {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                0, 1, 0, 0, 0
        );
        resultStatistics.put(RankNumber.SECOND, 1);
        double expected = 3_000_000;
        assertThat(Calculator.getYield(1_000, resultStatistics))
                .isEqualTo(expected);
    }

    @DisplayName("수익률 10,000,000% 이상 테스트")
    @Test
    void 수익률_반올림_계산_테스트_7() {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics(
                1, 0, 0, 0, 0
        );
        resultStatistics.put(RankNumber.FIRST, 1);
        double expected = 2.0E7;
        assertThat(Calculator.getYield(10_000, resultStatistics))
                .isEqualTo(expected);
    }

    EnumMap<RankNumber, Integer> initializeResultStatistics(
            int first,
            int second,
            int third,
            int fourth,
            int fifth
    ) {
        EnumMap<RankNumber, Integer> resultStatistics = new EnumMap<>(RankNumber.class);
        resultStatistics.put(RankNumber.FIRST, first);
        resultStatistics.put(RankNumber.SECOND, second);
        resultStatistics.put(RankNumber.THIRD, third);
        resultStatistics.put(RankNumber.FOURTH, fourth);
        resultStatistics.put(RankNumber.FIFTH, fifth);
        return resultStatistics;
    }
}
