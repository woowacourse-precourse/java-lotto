package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.MessageConstants.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 기능 테스트")
class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + WRONG_COUNT_MESSAGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + DUPLICATE_MESSAGE);
    }

    @DisplayName("로또 번호의 범위가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 0, 5, 49)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + WRONG_RANGE_MESSAGE);
    }

    @DisplayName("로또 번호 정렬이 잘 되는지 확인한다.")
    @Test
    void checkLottoWellSorted() {
        String numbersBeforeSortInString = "13,1,42,9,11,23";
        List<Integer> numbersBeforeSort = List.of(42,13,9,1,11,23);
        List<Integer> numbersAfterSort = List.of(1,9,11,13,23,42);

        Lotto testLotto1 = new Lotto(numbersBeforeSort);
        Lotto testLotto2 = new Lotto(numbersBeforeSortInString);

        assertThat(testLotto1.getNumbers()).isEqualTo(numbersAfterSort);
        assertThat(testLotto2.getNumbers()).isEqualTo(numbersAfterSort);
    }

    @DisplayName("로또 번호 비교 기능이 잘 동작하는지 확인한다.")
    @Test
    void checkLottoWellCompared() {
        Lotto testLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lottoToCompare = new Lotto(List.of(1,2,3,11,12,13));

        assertThat(testLotto.countMatchingNumbers(lottoToCompare)).isEqualTo(3);
    }
}
