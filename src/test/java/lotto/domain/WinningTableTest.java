package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningTableTest {

    @DisplayName("맞춘 번호가 6개이고 보너스를 맞췄을 때 1등인지 체크")
    @Test
    void getRank_case1() {
        assertThat(WinningTable.getRank(6, true))
                .isEqualTo(WinningTable.FIRST);
    }

    @DisplayName("맞춘 번호가 6개이고 보너스를 맞추지 못했을 때 1등인지 체크")
    @Test
    void getRank_case2() {
        assertThat(WinningTable.getRank(6, false))
                .isEqualTo(WinningTable.FIRST);
    }

    @DisplayName("맞춘 번호가 5개이고 보너스를 맞췄을 때 2등인지 체크")
    @Test
    void getRank_case3() {
        assertThat(WinningTable.getRank(5, true))
                .isEqualTo(WinningTable.SECOND);
    }

    @DisplayName("맞춘 번호가 5개이고 보너스를 맞추지 못했을 때 3등인지 체크")
    @Test
    void getRank_case4() {
        assertThat(WinningTable.getRank(5, false))
                .isEqualTo(WinningTable.THIRD);
    }

    @DisplayName("맞춘 번호가 4개이고 보너스를 맞췄을 때 4등인지 체크")
    @Test
    void getRank_case5() {
        assertThat(WinningTable.getRank(4, true))
                .isEqualTo(WinningTable.FORTH);
    }

    @DisplayName("맞춘 번호가 4개이고 보너스를 맞추지 못했을 때 4등인지 체크")
    @Test
    void getRank_case6() {
        assertThat(WinningTable.getRank(4, false))
                .isEqualTo(WinningTable.FORTH);
    }

    @DisplayName("맞춘 번호가 3개이고 보너스를 맞췄을 때 5등인지 체크")
    @Test
    void getRank_case7() {
        assertThat(WinningTable.getRank(3, true))
                .isEqualTo(WinningTable.FIFTH);
    }

    @DisplayName("맞춘 번호가 3개이고 보너스를 맞추지 못했을 때 5등인지 체크")
    @Test
    void getRank_case8() {
        assertThat(WinningTable.getRank(3, false))
                .isEqualTo(WinningTable.FIFTH);
    }

    @DisplayName("맞춘 번호가 2개이고 보너스를 맞췄을 때 꽝인지 체크")
    @Test
    void getRank_case9() {
        assertThat(WinningTable.getRank(2, true))
                .isEqualTo(WinningTable.LOSE);
    }

    @DisplayName("맞춘 번호가 2개이고 보너스를 맞추지 못했을 때 꽝인지 체크")
    @Test
    void getRank_case10() {
        assertThat(WinningTable.getRank(2, false))
                .isEqualTo(WinningTable.LOSE);
    }

    @DisplayName("맞춘 번호가 1개이고 보너스를 맞췄을 때 꽝인지 체크")
    @Test
    void getRank_case11() {
        assertThat(WinningTable.getRank(1, true))
                .isEqualTo(WinningTable.LOSE);
    }

    @DisplayName("맞춘 번호가 1개이고 보너스를 맞추지 못했을 때 꽝인지 체크")
    @Test
    void getRank_case12() {
        assertThat(WinningTable.getRank(1, false))
                .isEqualTo(WinningTable.LOSE);
    }

    @DisplayName("맞춘 번호가 0개이고 보너스를 맞췄을 때 꽝인지 체크")
    @Test
    void getRank_case13() {
        assertThat(WinningTable.getRank(0, true))
                .isEqualTo(WinningTable.LOSE);
    }

    @DisplayName("맞춘 번호가 0개이고 보너스를 맞추지 못했을 때 꽝인지 체크")
    @Test
    void getRank_case14() {
        assertThat(WinningTable.getRank(0, false))
                .isEqualTo(WinningTable.LOSE);
    }
}