package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("5,000원 당첨")
    @Test
    void case1() {
        int matchingWinningNumberCount = 3;
        int matchingBonusNumberCount = 0;

        Prize prize = new Prize(matchingWinningNumberCount, matchingBonusNumberCount);
        assertThat(prize.getMoney()).isEqualTo(5_000);
    }

    @DisplayName("50,000원 당첨")
    @Test
    void case2() {
        int matchingWinningNumberCount = 4;
        int matchingBonusNumberCount = 1;

        Prize prize = new Prize(matchingWinningNumberCount, matchingBonusNumberCount);
        assertThat(prize.getMoney()).isEqualTo(50_000);
    }

    @DisplayName("1,500,000원 당첨")
    @Test
    void case3() {
        int matchingWinningNumberCount = 5;
        int matchingBonusNumberCount = 0;

        Prize prize = new Prize(matchingWinningNumberCount, matchingBonusNumberCount);
        assertThat(prize.getMoney()).isEqualTo(1_500_000);
    }

    @DisplayName("30,000,000원 당첨 (보너스볼 일치)")
    @Test
    void case4() {
        int matchingWinningNumberCount = 5;
        int matchingBonusNumberCount = 1;

        Prize prize = new Prize(matchingWinningNumberCount, matchingBonusNumberCount);
        assertThat(prize.getMoney()).isEqualTo(30_000_000);
    }

    @DisplayName("2,000,000,000원 당첨 (보너스볼 일치)")
    @Test
    void case5() {
        int matchingWinningNumberCount = 6;
        int matchingBonusNumberCount = 0;

        Prize prize = new Prize(matchingWinningNumberCount, matchingBonusNumberCount);
        assertThat(prize.getMoney()).isEqualTo(2_000_000_000);
    }
}