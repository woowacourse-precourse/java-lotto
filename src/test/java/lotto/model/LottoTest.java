package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.NumbersValidator.NUMBERS_SIZE_ERROR;
import static lotto.model.NumbersValidator.NUMBER_RANGE_ERROR;
import static lotto.model.NumbersValidator.NUMBER_REPEAT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(NUMBERS_SIZE_ERROR);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(NUMBER_REPEAT_ERROR);
    }

    @DisplayName("로또 번호가 숫자가 범위를 초과하면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(NUMBER_RANGE_ERROR);
    }

    @DisplayName("두 로또를 비교하여 일치 한 숫자개수를 반환한다.")
    @Test
    void count_match_numbers_two_lotto(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto zeroMatchLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(lotto.countMathNumbers(zeroMatchLotto)).isEqualTo(0);

        Lotto allMatchLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.countMathNumbers(allMatchLotto)).isEqualTo(6);

        Lotto threeMatchLotto = new Lotto(List.of(4, 6, 11, 12, 13, 5));
        assertThat(lotto.countMathNumbers(threeMatchLotto)).isEqualTo(3);
    }

    @DisplayName("번호 포함 여부")
    @Test
    void contains_number() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsNumber(7)).isFalse();

        assertThat(lotto.containsNumber(1)).isTrue();
    }
}
