package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호가 1 ~ 45 사이의 정수가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 50, 6, 7, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 로또 번호는 중간에 다른 번호가 추가될 수 없다.")
    @Test
    void modifyLottoAddNumbers() {
        Lotto lotto = Lotto.createRandomLotto();
        assertThatThrownBy(() -> lotto.getNumbers().add(3))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("생성된 로또 번호는 중간에 삭제가 일어날 수 없다.")
    @Test
    void modifyLottoRemoveNumbers() {
        Lotto lotto = Lotto.createRandomLotto();
        assertThatThrownBy(() -> lotto.getNumbers().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

}
