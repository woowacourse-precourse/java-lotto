package lotto.domain;

import static lotto.utils.winning.RankUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @Test
    @DisplayName("1등에 당첨되면 1등 당첨 횟수를 카운트한다.")
    void winningCountTest() {
        // given
        WinningResult winningResult = new WinningResult();

        // when
        winningResult.addRank(FIRST);

        // then
        int firstCount = winningResult.getFirst();
        assertThat(firstCount).isEqualTo(1);
    }

    @Test
    @DisplayName("1등에 당첨되면 20억의 당첨금을 반환한다.")
    void winningFirstProfitTest() {
        // given
        long expected = (long)2e9;
        WinningResult winningResult = new WinningResult();

        // when
        winningResult.addRank(FIRST);

        // then
        long profit = winningResult.getProfit();
        assertThat(profit).isEqualTo(expected);
    }

    @Test
    @DisplayName("낙첨되면 당첨금은 없다.")
    void winningMissProfitTest() {
        // given
        long expected = 0L;
        WinningResult winningResult = new WinningResult();

        // when
        winningResult.addRank(MISS);

        // then
        long profit = winningResult.getProfit();
        assertThat(profit).isEqualTo(expected);
    }

}
