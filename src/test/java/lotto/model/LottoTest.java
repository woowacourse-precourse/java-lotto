package lotto.model;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호와 당첨 번호를 비교하고 맞힌 개수를 가져온다.")
    @Test
    void matchWithWinningNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int matchCount = 5;

        assertThat(lotto.matchWithWinningNumber(winningNumber)).isEqualTo(matchCount);
    }

    @DisplayName("로또 번호에서 원하는 위치의 번호를 가져온다.")
    @Test
    void get() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int index = 2;
        int number = 3;

        assertThat(lotto.get(index)).isEqualTo(number);
    }

    @DisplayName("로또 번호에 특정 번호가 포함되어 있는지 확인한다.")
    @Test
    void contains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 3;

        assertThat(lotto.contains(number)).isTrue();
    }
}
