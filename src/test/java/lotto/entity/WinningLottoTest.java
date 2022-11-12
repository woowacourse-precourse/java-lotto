package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 정해진 시작 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfStartRangeBonus() {
        //given
        int bonus = 0;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 정해진 끝 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfEndRangeBonus() {
        //given
        int bonus = 46;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 숫자를 가지면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateLottoNumber() {
        //given
        int bonus = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("로또가 번호가 1개 맞고 보너스가 맞지 않는 경우의 결과를 반환한다.")
    @Test
    void matchOneAndNotBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(6, 7, 8, 9, 10, 11)), 12);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.NONE);
    }

    @DisplayName("로또가 번호가 1개 맞고 보너스가 맞는 경우의 결과를 반환한다.")
    @Test
    void matchOneAndBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(6, 7, 8, 9, 10, 11)), 1);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.NONE);
    }

    @DisplayName("로또가 번호가 2개 맞고 보너스가 맞지 않는 경우의 결과를 반환한다.")
    @Test
    void matchTwoAndNotBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(5, 6, 7, 8, 9, 10)), 12);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.NONE);
    }

    @DisplayName("로또가 번호가 2개 맞고 보너스가 맞는 경우의 결과를 반환한다.")
    @Test
    void matchTwoAndBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(5, 6, 7, 8, 9, 10)), 1);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.NONE);
    }

    @DisplayName("로또가 번호가 3개 맞고 보너스가 맞지 않는 경우의 결과를 반환한다.")
    @Test
    void matchThreeAndNotBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(4, 5, 6, 7, 8, 9)), 12);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또가 번호가 3개 맞고 보너스가 맞는 경우의 결과를 반환한다.")
    @Test
    void matchThreeAndBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(4, 5, 6, 7, 8, 9)), 1);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또가 번호가 4개 맞고 보너스가 맞지 않는 경우의 결과를 반환한다.")
    @Test
    void matchFourAndNotBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(3, 4, 5, 6, 7, 8)), 12);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("로또가 번호가 4개 맞고 보너스가 맞는 경우의 결과를 반환한다.")
    @Test
    void matchFourAndBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(3, 4, 5, 6, 7, 8)), 1);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("로또가 번호가 5개 맞고 보너스가 맞지 않는 경우의 결과를 반환한다.")
    @Test
    void matchFiveAndNotBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(2, 3, 4, 5, 6, 7)), 12);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또가 번호가 5개 맞고 보너스가 맞는 경우의 결과를 반환한다.")
    @Test
    void matchFiveAndBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(2, 3, 4, 5, 6, 7)), 1);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또가 번호가 6개 맞고 보너스가 맞지 않는 경우의 결과를 반환한다.")
    @Test
    void matchSixAndNotBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 12);

        //when
        Rank result = winningLotto.compare(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FIRST);
    }

}