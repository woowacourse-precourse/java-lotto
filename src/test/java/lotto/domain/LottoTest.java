package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호 6개가 모두 맞다는다면 1등이다.")
    @Test
    void getRankFirst() {
        WinningNumber winningNumber = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.addBonus(7);

        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getRank(winningNumber))
                .isEqualTo(Rank.FIRST);
    }

    @DisplayName("번호 5개, 보너스 번호가 맞다는다면 2등이다.")
    @Test
    void getRankSecond() {
        WinningNumber winningNumber = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.addBonus(7);

        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 7)).getRank(winningNumber))
                .isEqualTo(Rank.SECOND);
    }

    @DisplayName("번호 5개가 맞다는다면 3등이다.")
    @Test
    void getRankThird() {
        WinningNumber winningNumber = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.addBonus(7);

        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 11)).getRank(winningNumber))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("번호 4개가 맞다는다면 4등이다.")
    @Test
    void getRankForth() {
        WinningNumber winningNumber = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.addBonus(7);

        assertThat(new Lotto(List.of(1, 2, 3, 4, 15, 16)).getRank(winningNumber))
                .isEqualTo(Rank.FORTH);
    }

    @DisplayName("번호 3개가 맞다는다면 5등이다.")
    @Test
    void getRankFifth() {
        WinningNumber winningNumber = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.addBonus(7);

        assertThat(new Lotto(List.of(1, 2, 3, 14, 15, 16)).getRank(winningNumber))
                .isEqualTo(Rank.FIFTH);
    }

    @DisplayName("번호 2개 이하로 맞는다면 낙첨이다.")
    @Test
    void getRankNoLuck() {
        WinningNumber winningNumber = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.addBonus(7);

        assertThat(new Lotto(List.of(1, 2, 13, 14, 15, 16)).getRank(winningNumber))
                .isEqualTo(Rank.NO_LUCK);
    }
}
