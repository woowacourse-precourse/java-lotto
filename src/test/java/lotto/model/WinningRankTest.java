package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningRankTest {

    @DisplayName("당첨 로또와 매칭 개수를 통해 당첨 rank를 구한다.")
    @Test
    void findWinningRankTest() {
        WinningRank winningRank1 = WinningRank.findWinningRank(0, false);
        WinningRank winningRank2 = WinningRank.findWinningRank(1, false);
        WinningRank winningRank3 = WinningRank.findWinningRank(2, false);
        WinningRank winningRank4 = WinningRank.findWinningRank(3, false);
        WinningRank winningRank5 = WinningRank.findWinningRank(4, false);
        WinningRank winningRank6 = WinningRank.findWinningRank(5, false);
        WinningRank winningRank7 = WinningRank.findWinningRank(5, true);
        WinningRank winningRank8 = WinningRank.findWinningRank(6, false);

        assertThat(winningRank1).isEqualTo(WinningRank.NO_MATCH);
        assertThat(winningRank2).isEqualTo(WinningRank.NO_MATCH);
        assertThat(winningRank3).isEqualTo(WinningRank.NO_MATCH);
        assertThat(winningRank4).isEqualTo(WinningRank.THREE_MATCH);
        assertThat(winningRank5).isEqualTo(WinningRank.FOUR_MATCH);
        assertThat(winningRank6).isEqualTo(WinningRank.FIVE_MATCH);
        assertThat(winningRank7).isEqualTo(WinningRank.FIVE_MATCH_BONUS);
        assertThat(winningRank8).isEqualTo(WinningRank.SIX_MATCH);
    }
}
