package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.SIZE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.DUPLICATION_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 1~45사이 번호아닌 경우 예외가 발생한다.")
    void validateNumberScope() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.SCOPE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("수동 로또 번호가 오름차순으로 저장된다.")
    void manualLottoAscendingOrderTest() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        Assertions.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("자동 로또 번호가 오름차순으로 저장된다.")
    void autoLottoAscendingOrderTest2() {
        Lotto lotto = Lotto.createRandomNumbers();
        List<Integer> list = lotto.getNumbers();
        Assertions.assertThat(isSorted(list)).isTrue();
    }

    public static boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }


}
