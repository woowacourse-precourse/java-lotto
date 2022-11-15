package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerLottoTest {
    @DisplayName("당첨번호 입력 시 숫자가 아닌값이 포함되면 예외가 발생한다.")
    @Test
    void numberNotInt() {
        assertThatThrownBy(() -> new WinnerLotto("1,2,3,4,5,안녕", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호 입력 시 숫자가 아닌값이 포함되면 예외가 발생한다.")
    @Test
    void bonusNotInt() {
        assertThatThrownBy(() -> new WinnerLotto("1,2,3,4,5,6", "안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1개보다 많은 경우 예외가 발생한다.")
    @Test
    void bonusOverOne() {
        assertThatThrownBy(() -> new WinnerLotto("1,2,3,4,5,6", "7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1개보다 적은 경우 예외가 발생한다.")
    @Test
    void bonusUnderOne() {
        assertThatThrownBy(() -> new WinnerLotto("1,2,3,4,5,6", ""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호와 당첨번호 중복 시 예외가 발생한다.")
    @Test
    void bonusDuplicate() {
        assertThatThrownBy(() -> new WinnerLotto("1,2,3,4,5,6", "4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 3개 미만이고 보너스번호가 일치하지 않으면 당첨내역이 없다.")
    @Test
    void noReward() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(38, 39, 40, 41, 43, 45));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(0);
        assertThat(lottoRank.getReward()).isEqualTo(0);
    }

    @DisplayName("당첨번호가 3개 미만이고 보너스번호가 일치하면 당첨내역이 없다.")
    @Test
    void noRewardAnd() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(7, 39, 40, 41, 43, 45));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(0);
        assertThat(lottoRank.getReward()).isEqualTo(0);
    }

    @DisplayName("당첨번호 3개가 일치하면 당첨내역 5등을 반환한다.")
    @Test
    void matchFifth() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 41, 43, 45));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(3);
        assertThat(lottoRank.getReward()).isEqualTo(5000);
    }

    @DisplayName("당첨번호 3개와 보너스번호가 일치하면 당첨내역 5등을 반환한다.")
    @Test
    void matchFifthAnd() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 43, 45));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(3);
        assertThat(lottoRank.getReward()).isEqualTo(5000);
    }

    @DisplayName("당첨번호 4개가 일치하면 당첨내역 4등을 반환한다.")
    @Test
    void matchFourth() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 43, 45));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(4);
        assertThat(lottoRank.getReward()).isEqualTo(50000);
    }

    @DisplayName("당첨번호 4개와 보너스번호가 일치하면 당첨내역 4등을 반환한다.")
    @Test
    void matchFourthAnd() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 45));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(4);
        assertThat(lottoRank.getReward()).isEqualTo(50000);
    }

    @DisplayName("당첨번호 5개가 일치하고 보너스번호가 일치하지 않으면 당첨내역 3등을 반환한다.")
    @Test
    void matchThird() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 6, 45));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(5);
        assertThat(lottoRank.getReward()).isEqualTo(1500000);
    }

    @DisplayName("당첨번호 5개와 보너스번호가 일치하면 당첨내역 2등을 반환한다.")
    @Test
    void matchSecond() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 6, 7));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(5);
        assertThat(lottoRank.getReward()).isEqualTo(30000000);
    }

    @DisplayName("당첨번호 6개가 일치하면 당첨내역 1등을 반환한다.")
    @Test
    void matchFirst() {
        //given
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", "7");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoRank lottoRank = winnerLotto.matchAll(lotto);

        //then
        assertThat(lottoRank.getMatchCount()).isEqualTo(6);
        assertThat(lottoRank.getReward()).isEqualTo(2000000000);
    }
}
