package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("당첨 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 1~45 사이의 숫자가 아닌 다른 숫자가 들어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByNotInEffectiveRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 47), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 보너스 숫자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersContainsBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 0이 들어갈 경우 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersWithZeroBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또와 로또를 비교하여 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,FIRST", "2,3,4,5,6,7,SECOND", "2,3,4,5,6,8,THIRD"
            , "3,4,5,6,7,8,FOURTH", "4,5,6,7,8,9,FIFTH"})
    public void computeRank(int n1, int n2, int n3, int n4, int n5, int n6, Rank result) {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Rank rank = winningLotto.computeRank(new Lotto(List.of(n1, n2, n3, n4, n5, n6)));
        Assertions.assertThat(rank).isEqualTo(result);
    }
}