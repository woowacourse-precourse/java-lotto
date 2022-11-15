package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.ticket.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    @DisplayName("당첨 개수 확인")
    void valueOf() {
        assertAll(
                () -> assertThat(Winning.valueOf(1, false)).isEqualTo(Winning.FAIL),
                () -> assertThat(Winning.valueOf(2, false)).isEqualTo(Winning.FAIL),
                () -> assertThat(Winning.valueOf(3, false)).isEqualTo(Winning.THREE),
                () -> assertThat(Winning.valueOf(4, false)).isEqualTo(Winning.FOUR),
                () -> assertThat(Winning.valueOf(5, false)).isEqualTo(Winning.FIVE),
                () -> assertThat(Winning.valueOf(5, true)).isEqualTo(Winning.BONUS),
                () -> assertThat(Winning.valueOf(6, false)).isEqualTo(Winning.SIX)
        );
    }

    @Test
    @DisplayName("상금 계산 확인")
    void getTotalRewards() {
        int secondRewards = Winning.BONUS.getRewards();
        int count = 2;
        assertThat(Winning.BONUS.getTotalRewards(count)).isEqualTo(secondRewards * count);
    }
}