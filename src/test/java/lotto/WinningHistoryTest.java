package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningHistoryTest {
    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 6개 일치 -> 1등 당첨")
    @Test
    void checkSizMatch() {
        assertThat(WinningHistory.getWinningHistoryType(6, false)).isEqualTo(WinningHistory.FIRST_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 5개 일치, 보너스 일치 -> 2등 당첨")
    @Test
    void checkFiveMatchWithBonus() {
        assertThat(WinningHistory.getWinningHistoryType(5, true)).isEqualTo(WinningHistory.SECOND_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 5개 일치 -> 3등 당첨")
    @Test
    void checkFiveMatch() {
        assertThat(WinningHistory.getWinningHistoryType(5, false)).isEqualTo(WinningHistory.THIRD_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 4개 일치, 보너스 일치 -> 3등 당첨")
    @Test
    void checkFourMatchWithBonus() {
        assertThat(WinningHistory.getWinningHistoryType(4, true)).isEqualTo(WinningHistory.THIRD_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 4개 일치 -> 4등 당첨")
    @Test
    void checkFourMatch() {
        assertThat(WinningHistory.getWinningHistoryType(4, false)).isEqualTo(WinningHistory.FOURTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 3개 일치, 보너스 일치 -> 4등 당첨")
    @Test
    void checkThreeMatchWithBonus() {
        assertThat(WinningHistory.getWinningHistoryType(3, true)).isEqualTo(WinningHistory.FOURTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 3개 일치 -> 5등 당첨")
    @Test
    void checkThreeMatch() {
        assertThat(WinningHistory.getWinningHistoryType(3, false)).isEqualTo(WinningHistory.FIFTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 2개 일치, 보너스 일치 -> 5등 당첨")
    @Test
    void checkTwoMatchWithBonus() {
        assertThat(WinningHistory.getWinningHistoryType(2, true)).isEqualTo(WinningHistory.FIFTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 2개 일치 -> 낙첨")
    @Test
    void checkTwoMatch() {
        assertThat(WinningHistory.getWinningHistoryType(2, false)).isEqualTo(WinningHistory.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 1개 일치, 보너스 일치 -> 낙첨")
    @Test
    void checkOneMatchWithBonus() {
        assertThat(WinningHistory.getWinningHistoryType(1, true)).isEqualTo(WinningHistory.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 1개 일치 -> 낙첨")
    @Test
    void checkOneMatch() {
        assertThat(WinningHistory.getWinningHistoryType(1, false)).isEqualTo(WinningHistory.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 0개 일치, 보너스 일치 -> 낙첨")
    @Test
    void checkNoneMatchWithBonus() {
        assertThat(WinningHistory.getWinningHistoryType(0, true)).isEqualTo(WinningHistory.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 0개 일치 -> 낙첨")
    @Test
    void checkNoneMatch() {
        assertThat(WinningHistory.getWinningHistoryType(0, false)).isEqualTo(WinningHistory.BLANK);
    }
}
