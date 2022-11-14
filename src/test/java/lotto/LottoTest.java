package lotto;

import lotto.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 지정된 숫자 범위안에 존재하지 않는다면 예외가 발생한다.")
    @Test
    void createLottoByBetweenValue() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 4, 5, 6, 49)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 6개 맞추면 1등이다.")
    @Test
    void createLottoByRankOne() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(lotto.getRank(winningNumbers, bonusNumber)).isEqualTo(Rank.ONE);
    }

    @DisplayName("당첨번호 5개 맞추고 보너스 번호 맞추면 2등이다.")
    @Test
    void createLottoByRankTwo() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(lotto.getRank(winningNumbers, bonusNumber)).isEqualTo(Rank.TWO);
    }

    @DisplayName("당첨번호 5개 맞추면 3등이다.")
    @Test
    void createLottoByRankThree() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(lotto.getRank(winningNumbers, bonusNumber)).isEqualTo(Rank.THREE);
    }

    @DisplayName("당첨번호 4개 맞추면 4등이다.")
    @Test
    void createLottoByRankFour() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(lotto.getRank(winningNumbers, bonusNumber)).isEqualTo(Rank.FOUR);
    }

    @DisplayName("당첨번호 3개 맞추면 5등이다.")
    @Test
    void createLottoByRankFive() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 9, 10));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(lotto.getRank(winningNumbers, bonusNumber)).isEqualTo(Rank.FIVE);
    }

    @DisplayName("당첨번호 3개 미만이면 아무것도 아니다.")
    @Test
    void createLottoByRankNone() {
        Lotto lotto = new Lotto(List.of(1, 9, 10, 11, 12, 13));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(lotto.getRank(winningNumbers, bonusNumber)).isEqualTo(Rank.NONE);
    }

}
