package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.service.Ranks;
import lotto.service.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    private int initialWinCount;
    private Map<Integer, Integer> initialStatistics;

    @BeforeEach
    void setUp() {
        initialWinCount = 0;
        initialStatistics = new LinkedHashMap<>();
        for (Ranks ranks : Ranks.values()) {
            initialStatistics.put(ranks.getPrizeMoney(), initialWinCount);
        }
    }

    @DisplayName("당첨 통계: 5,000원 1회")
    @Test
    void case1() {
        List<Integer> profit = List.of(5_000);
        Calculator.updateStatistics(initialStatistics, profit);

        Map<Integer, Integer> expected = Map.of(
                5_000, 1,
                5_0000, 0,
                1_500_000, 0,
                30_000_000, 0,
                2_000_000_000, 0
        );
        assertThat(initialStatistics).isEqualTo(expected);
    }

    @DisplayName("당첨 통계: 5,000원 1회, 50,000원 1회")
    @Test
    void case2() {
        List<Integer> profit = List.of(50_000, 5_000);
        Calculator.updateStatistics(initialStatistics, profit);

        Map<Integer, Integer> expected = Map.of(
                5_000, 1,
                5_0000, 1,
                1_500_000, 0,
                30_000_000, 0,
                2_000_000_000, 0
        );
        assertThat(initialStatistics).isEqualTo(expected);
    }

    @DisplayName("당첨 통계: 5,000원 3회, 50,000원 2회, 1,500,000원 1회")
    @Test
    void case3() {
        List<Integer> profit = List.of(
                50_000, 5_000,
                5_000, 1_500_000,
                50_000, 5_000
        );
        Calculator.updateStatistics(initialStatistics, profit);

        Map<Integer, Integer> expected = Map.of(
                5_000, 3,
                5_0000, 2,
                1_500_000, 1,
                30_000_000, 0,
                2_000_000_000, 0
        );
        assertThat(initialStatistics).isEqualTo(expected);
    }

    @DisplayName("당첨 통계: 5,000원 10회, 1,500,000원 1회, 2,000,000,000원 1회")
    @Test
    void case4() {
        List<Integer> profit = List.of(
                    1_500_000, 5_000,
                    2_000_000_000, 5_000,
                    5_000, 5_000,
                    5_000, 5_000,
                    5_000, 5_000,
                    5_000, 5_000
        );
        Calculator.updateStatistics(initialStatistics, profit);

        Map<Integer, Integer> expected = Map.of(
                5_000, 10,
                5_0000, 0,
                1_500_000, 1,
                30_000_000, 0,
                2_000_000_000, 1
        );
        assertThat(initialStatistics).isEqualTo(expected);
    }

    @DisplayName("당첨 통계: 5,000원 2회, 1,500,000원 1회 ,30,000,000원 1회")
    @Test
    void case5() {
        List<Integer> profit = List.of(5_000, 30_000_000, 5_000, 1_500_000);
        Calculator.updateStatistics(initialStatistics, profit);

        Map<Integer, Integer> expected = Map.of(
                5_000, 2,
                5_0000, 0,
                1_500_000, 1,
                30_000_000, 1,
                2_000_000_000, 0
        );
        assertThat(initialStatistics).isEqualTo(expected);
    }
}