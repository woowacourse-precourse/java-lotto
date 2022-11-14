package lotto.calculation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    List<List<Integer>> multipleTickets = new ArrayList<>();
    List<Integer> LottoTicket = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8));
    List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    Integer bonusNumber = 8;

    @Test
    void rankCheckTest() {
        assertThat(WinningResult.rankCheck(LottoTicket,winningNumber,bonusNumber)).isEqualTo("2등");
        assertThat(WinningResult.rankCheck(winningNumber,winningNumber,bonusNumber)).isEqualTo("1등");
    }//rankCheckTest

    @Test
    void calculateStatisticsTest() {
        multipleTickets.add(LottoTicket);
        multipleTickets.add(winningNumber);
        Map<String,Integer> statistics = WinningResult.calculateStatistics(multipleTickets,winningNumber,bonusNumber);

        assertThat(statistics.get("2등")).isEqualTo(1);
        assertThat(statistics.get("1등")).isEqualTo(1);
    }//calculateStatisticsTest
}// end class
