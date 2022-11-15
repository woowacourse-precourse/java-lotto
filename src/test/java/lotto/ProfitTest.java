package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Profit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {
    @DisplayName("3개 일치, 5,000원 당첨")
    @Test
    void case1() {
        final int matchingWinningNumberCount = 3;
        final int matchingBonusNumberCount = 1;

        Profit profit = new Profit(matchingWinningNumberCount, matchingBonusNumberCount);
        Integer expected = 5_000;
        assertThat(profit.getProfit()).isEqualTo(expected);
    }

    @DisplayName("4개 일치, 50,000원 당첨")
    @Test
    void case2() {
        final int matchingWinningNumberCount = 4;
        final int matchingBonusNumberCount = 0;

        Profit profit = new Profit(matchingWinningNumberCount, matchingBonusNumberCount);
        Integer expected = 50_000;
        assertThat(profit.getProfit()).isEqualTo(expected);
    }

    @DisplayName("5개 일치 (보너스볼 불일치), 1_500,000원 당첨")
    @Test
    void case3() {
        final int matchingWinningNumberCount = 5;
        final int matchingBonusNumberCount = 0;

        Profit profit = new Profit(matchingWinningNumberCount, matchingBonusNumberCount);
        Integer expected = 1_500_000;
        assertThat(profit.getProfit()).isEqualTo(expected);
    }

    @DisplayName("5개 일치 (보너스볼 일치), 30,000,000원 당첨")
    @Test
    void case4() {
        final int matchingWinningNumberCount = 5;
        final int matchingBonusNumberCount = 1;

        Profit profit = new Profit(matchingWinningNumberCount, matchingBonusNumberCount);
        Integer expected = 30_000_000;
        assertThat(profit.getProfit()).isEqualTo(expected);
    }

    @DisplayName("6개 일치, 2,000,000,000원 당첨 부럽다")
    @Test
    void case5() {
        final int matchingWinningNumberCount = 6;
        final int matchingBonusNumberCount = 0;

        Profit profit = new Profit(matchingWinningNumberCount, matchingBonusNumberCount);
        Integer expected = 2_000_000_000;
        assertThat(profit.getProfit()).isEqualTo(expected);
    }
}