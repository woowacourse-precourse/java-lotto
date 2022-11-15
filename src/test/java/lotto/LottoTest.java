package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호가 1미만 이라면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45초과라면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 46, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("저장된 로또 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void checkLottoSorted() {
        Lotto lotto = new Lotto(Arrays.asList(9, 8, 7, 6, 5, 4));
        assertThat(lotto.getLotto()).isEqualTo(List.of(4, 5, 6, 7, 8, 9));
    }
}
