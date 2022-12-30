package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    void 로또_번호_6개_포함() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningLotto = new WinningNumber(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 10
        );

        int sameNumber = lotto.compareWinNum(winningLotto);
        assertThat(sameNumber)
                .isEqualTo(6);
    }

    @Test
    void 로또_번호_0개_포함() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningLotto = new WinningNumber(
                new Lotto(Arrays.asList(7,8,9,11,12,13)), 10
        );

        int sameNumber = lotto.compareWinNum(winningLotto);
        assertThat(sameNumber)
                .isEqualTo(0);
    }

    @Test
    void 보너스_번호_포함() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    void 보너스_번호_미포함() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(45)).isFalse();
    }
}
