package lotto.model;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @Test
    void 발행한_로또_번호의_범위가_1부터_45가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 발행한_로또_번호_오름차순() {
        List<Integer> notSortedNumbers = List.of(4, 6, 3, 2, 1, 5);
        Lotto lotto = new Lotto(notSortedNumbers);
        List<Integer> sortedNumbers = lotto.getNumbers();

        assertThat(sortedNumbers.get(0)).isNotEqualTo(4);
        assertThat(sortedNumbers.get(0)).isEqualTo(1);
        assertThat(sortedNumbers.get(notSortedNumbers.size() - 1)).isNotEqualTo(5);
        assertThat(sortedNumbers.get(notSortedNumbers.size() - 1)).isEqualTo(6);
    }
}
