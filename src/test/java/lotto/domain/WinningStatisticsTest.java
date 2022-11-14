package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    @DisplayName("각 등수마다 몇 개씩 당첨되었는지 계산 -> 1등 1개, 2등 2개, 5등 2개, 꽝 1개")
    void getWinningDetailsTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Lotto lotto4 = new Lotto(List.of(40, 2, 3, 43, 44, 6));
        Lotto lotto5 = new Lotto(List.of(40, 2, 3, 4, 5, 6));
        Lotto lotto6 = new Lotto(List.of(40, 1, 2, 3, 4, 5));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 40);
        Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottos, winningLotto);

        assertThat(winningDetails.get(WinningRank.LAST_PLACE)).isEqualTo(1);
        assertThat(winningDetails.get(WinningRank.FIFTH_PLACE)).isEqualTo(2);
        assertThat(winningDetails.get(WinningRank.SECOND_PLACE)).isEqualTo(2);
        assertThat(winningDetails.get(WinningRank.FIRST_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 내역을 이용해 당첨 금액을 구한다.")
    void getWinningAmountTest() {
        Map<WinningRank, Integer> winningDetails = WinningRank.generateWinningDetails();
        winningDetails.replace(WinningRank.SECOND_PLACE, 2);
        winningDetails.replace(WinningRank.FOURTH_PLACE, 5);
        winningDetails.replace(WinningRank.FIFTH_PLACE, 13);

        long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
        assertThat(winningAmount).isEqualTo(60_315_000);
    }
}
