package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {
    @DisplayName("1등 복권 1개, 2등 복권 1개, 3등 복권 1개에 당첨되면 총 상금은 2_031_500_000원이다.")
    @Test
    void calculateTotalPrize() {
        Map<Rank, Integer> statistics = new HashMap<>();
        statistics.put(Rank.FIRST, 1);
        statistics.put(Rank.SECOND, 1);
        statistics.put(Rank.THIRD, 1);
        WinningStatistics winningStatistics = new WinningStatistics(statistics);

        long totalPrize = winningStatistics.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(2_031_500_000L);
    }
}