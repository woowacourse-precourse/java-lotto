package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Winner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class WinnerTest {

    @Test
    @DisplayName("당첨 번호 개수에 맞는 등수 및 금액 추출 테스트")
    void getWinningPrizeFromWinningCount() {
        int winningCount = 3;
        boolean isBonusNumber = false;

        Winner winner = Winner.getWinner(winningCount, isBonusNumber);

        assertThat(Winner.FIFTH).isEqualTo(winner);
        assertThat(5000).isEqualTo(winner.getPrize());
    }
}