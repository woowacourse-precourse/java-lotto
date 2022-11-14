package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StatisticsCalculatorTest {
    @DisplayName("통계 계산 기능")
    @Nested
    class CalculateStatistics {
        List<Lotto> generatedLottos = new ArrayList<>();
        WinningNumber winningNumber;

        @BeforeEach
        public void setUp() {
            List<List<Integer>> mocklists = List.of(
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(1, 2, 3, 4, 5, 7),
                    List.of(7, 11, 16, 35, 36, 44),
                    List.of(1, 8, 11, 31, 41, 42),
                    List.of(13, 14, 16, 38, 42, 45),
                    List.of(7, 11, 30, 40, 42, 43),
                    List.of(2, 13, 22, 32, 38, 45),
                    List.of(1, 3, 5, 14, 22, 45)
            );
            mocklists.forEach(
                    list -> generatedLottos.add(new Lotto(list))
            );
            winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        }

        @DisplayName("6개 일치, 5개 + 보너스 일치, 3개 일치")
        @Test
        public void calculateStatistics() {
            Map<LottoPrize, Integer> statistics = StatisticsCalculator.calculateStatistics(generatedLottos,
                    winningNumber);
            assertThat(statistics.get(LottoPrize.FIFTH)).isEqualTo(1);
            assertThat(statistics.get(LottoPrize.FOURTH)).isEqualTo(0);
            assertThat(statistics.get(LottoPrize.THIRD)).isEqualTo(0);
            assertThat(statistics.get(LottoPrize.SECOND)).isEqualTo(1);
            assertThat(statistics.get(LottoPrize.FIRST)).isEqualTo(1);
        }
    }

    @DisplayName("수익률 계산 기능")
    @Nested
    class CalculateRateOfReturn {
        Map<LottoPrize, Integer> mockStatistics;

        @Test
        public void calculateRateOfReturn() {
            mockStatistics = Map.ofEntries(
                    entry(LottoPrize.FIRST, 1),
                    entry(LottoPrize.SECOND, 1),
                    entry(LottoPrize.THIRD, 2),
                    entry(LottoPrize.FOURTH, 1),
                    entry(LottoPrize.FIFTH, 0)
            );
            double mockRateOfReturn = StatisticsCalculator.calculateRateOfReturn(7000, mockStatistics);
            double expectedRateOfReturn = 29043571.4;
            System.out.println(mockRateOfReturn);
            assertThat(mockRateOfReturn).isEqualTo(expectedRateOfReturn);
        }

        @Test
        public void calculateRateOfReturn2() {
            mockStatistics = Map.ofEntries(
                    entry(LottoPrize.FIRST, 0),
                    entry(LottoPrize.SECOND, 0),
                    entry(LottoPrize.THIRD, 1),
                    entry(LottoPrize.FOURTH, 0),
                    entry(LottoPrize.FIFTH, 0)
            );
            double mockRateOfReturn = StatisticsCalculator.calculateRateOfReturn(17000, mockStatistics);
            double expectedRateOfReturn = 8823.5;
            System.out.println(mockRateOfReturn);
            assertThat(mockRateOfReturn).isEqualTo(expectedRateOfReturn);
        }
    }
}