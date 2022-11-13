package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_DUPLICATION);
    }

    @DisplayName("로또 번호 6개가 모두 같으면 같은 로또로 간주한다.")
    @Test
    void equalLottos() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.equals(otherLotto)).isTrue();
    }

    @DisplayName("로또 번호가 1개라도 다르면 다른 로또로 간주한다.")
    @Test
    void notEqualLottos() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(1, 2, 3, 10, 5, 6));
        assertThat(lotto.equals(otherLotto)).isFalse();
    }

    @DisplayName("인자로 전달되는 로또와 일치하는 번호의 갯수를 반환한다. - 0개 일치")
    @Test
    void countNumberOfMatchTestNothing() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(lotto.countNumberOfMatch(otherLotto)).isEqualTo(0);
    }

    @DisplayName("인자로 전달되는 로또와 일치하는 번호의 갯수를 반환한다. - 모두 일치")
    @Test
    void countNumberOfMatchTestAll() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.countNumberOfMatch(otherLotto)).isEqualTo(6);
    }

    @DisplayName("인자로 전달되는 로또와 일치하는 번호의 갯수를 반환한다.")
    @Test
    void countNumberOfMatchTestSome() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        assertThat(lotto.countNumberOfMatch(otherLotto)).isEqualTo(3);
    }

    @DisplayName("인자로 전달되는 로또 번호를 가지고 있는지 판단한다. - 가지고 있음")
    @Test
    void hasNumberTestTrue() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.hasNumber(3)).isTrue();
    }

    @DisplayName("인자로 전달되는 로또 번호를 가지고 있는지 판단한다. - 가지고 있지 않음")
    @Test
    void hasNumberTestFalse() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.hasNumber(10)).isFalse();
    }
}
