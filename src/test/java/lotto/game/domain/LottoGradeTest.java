package lotto.game.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGradeTest {
    @Test
    @DisplayName("당첨 번호가 6개면 1등을 반환한다.")
    void createLottoGradeByWinningCount6() {
        // given
        int winningCount = 6;
        boolean bonusMatch = false;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.FIRST);
    }

    @Test
    @DisplayName("당첨 번호가 5개이고 보너스 번호가 맞으면 2등을 반환한다.")
    void createLottoGradeByWinningCount5AndBonusMatch() {
        // given
        int winningCount = 5;
        boolean bonusMatch = true;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.SECOND);
    }

    @Test
    @DisplayName("당첨 번호가 5개면 3등을 반환한다.")
    void createLottoGradeByWinningCount5() {
        // given
        int winningCount = 5;
        boolean bonusMatch = false;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.THIRD);
    }

    @Test
    @DisplayName("당첨 번호가 4개면 4등을 반환한다.")
    void createLottoGradeByWinningCount4() {
        // given
        int winningCount = 4;
        boolean bonusMatch = false;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호가 4개이고 보너스 번호가 맞으면 4등을 반환한다.")
    void createLottoGradeByWinningCount4AndBonusMatch() {
        // given
        int winningCount = 4;
        boolean bonusMatch = true;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호가 3개면 5등을 반환한다.")
    void createLottoGradeByWinningCount3() {
        // given
        int winningCount = 3;
        boolean bonusMatch = false;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호가 3개이고 보너스 번호가 맞으면 5등을 반환한다.")
    void createLottoGradeByWinningCount3AndBonusMatch() {
        // given
        int winningCount = 3;
        boolean bonusMatch = true;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호가 2개면 낫싱을 반환한다.")
    void createLottoGradeByWinningCount2() {
        // given
        int winningCount = 2;
        boolean bonusMatch = false;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.NOTHING);
    }

    @Test
    @DisplayName("당첨 번호가 2개이고 보너스 번호가 맞으면 낫싱을 반환한다.")
    void createLottoGradeByWinningCount2AndBonusMatch() {
        // given
        int winningCount = 2;
        boolean bonusMatch = true;

        // expect
        assertThat(LottoGrade.confirmWinning(winningCount, bonusMatch))
                .isEqualTo(LottoGrade.NOTHING);
    }
}