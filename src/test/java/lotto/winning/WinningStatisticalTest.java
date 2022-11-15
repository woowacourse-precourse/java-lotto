package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningStatisticalTest {
    @Test
    public void addWinningResultSuccessTest() throws Exception {
        // given
        WinningStatistical winningStatistical = new WinningStatistical();

        // when
        winningStatistical.addWinningResult(WinningResult.FIRST_PRIZE);
        winningStatistical.addWinningResult(WinningResult.FIRST_PRIZE);
        winningStatistical.addWinningResult(WinningResult.FIFTH_PRIZE);
        winningStatistical.addWinningResult(WinningResult.FORTH_PRIZE);

        // then
        assertThat(winningStatistical.getCountOfWinningResult(WinningResult.FIRST_PRIZE)).isEqualTo(2);
        assertThat(winningStatistical.getCountOfWinningResult(WinningResult.FIFTH_PRIZE)).isEqualTo(1);
        assertThat(winningStatistical.getCountOfWinningResult(WinningResult.FORTH_PRIZE)).isEqualTo(1);
        assertThat(winningStatistical.getCountOfWinningResult(WinningResult.SECOND_PRIZE)).isEqualTo(0);

        assertThat(winningStatistical.calculateProfit()).isEqualTo(100_001_375);
    }
}