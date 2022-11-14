package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {

    @Test
    @DisplayName("당첨 번호 일치 개수와 보너스 번호 일치 여부를 통해서 당첨 등수를 구한다.")
    void findWinningRankTest() {
        WinningRank winningRank1 = WinningRank.findWinningRank(0, false);
        WinningRank winningRank2 = WinningRank.findWinningRank(1, false);
        WinningRank winningRank3 = WinningRank.findWinningRank(2, false);
        WinningRank winningRank4 = WinningRank.findWinningRank(3, false);
        WinningRank winningRank5 = WinningRank.findWinningRank(4, false);
        WinningRank winningRank6 = WinningRank.findWinningRank(5, false);
        WinningRank winningRank7 = WinningRank.findWinningRank(5, true);
        WinningRank winningRank8 = WinningRank.findWinningRank(6, false);

        assertThat(winningRank1).isEqualTo(WinningRank.LAST_PLACE);
        assertThat(winningRank2).isEqualTo(WinningRank.LAST_PLACE);
        assertThat(winningRank3).isEqualTo(WinningRank.LAST_PLACE);
        assertThat(winningRank4).isEqualTo(WinningRank.FIFTH_PLACE);
        assertThat(winningRank5).isEqualTo(WinningRank.FOURTH_PLACE);
        assertThat(winningRank6).isEqualTo(WinningRank.THIRD_PLACE);
        assertThat(winningRank7).isEqualTo(WinningRank.SECOND_PLACE);
        assertThat(winningRank8).isEqualTo(WinningRank.FIRST_PLACE);
    }
}
