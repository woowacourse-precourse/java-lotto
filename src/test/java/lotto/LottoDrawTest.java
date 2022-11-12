package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoDrawTest {
    @DisplayName("당첨 번호와 로또 번호가 모두 같을 경우 1등을 반환한다.")
    @Test
    void testFirstPlace() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("당첨 번호 5개가 일치하고 보너스 숫자가 일치할 경우 2등을 반환한다.")
    @Test
    void testSecondPlace() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 45), 6);

        LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);

        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("당첨 번호 5개가 일치하고 보너스 숫자가 일치하지 않을 경우 3등을 반환한다.")
    @Test
    void testThirdPlace() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 45), 7);

        LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);

        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("당첨 번호 4개가 일치할 경우 4등을 반환한다.")
    @Test
    void testFourthPlace() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 44, 45), 6);

        LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);

        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("당첨 번호 3개가 일치할 경우 5등을 반환한다.")
    @Test
    void testFifthPlace() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 43, 44, 45), 6);

        LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);

        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("당첨 번호가 2개 이하 일치할 경우 꽝을 반환한다.")
    @Test
    void testLose() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(List.of(1, 2, 42, 43, 44, 45), 6);

        LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);

        assertThat(rank).isEqualTo(LottoRank.LOSE);
    }
}