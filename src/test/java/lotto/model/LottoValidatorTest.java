package lotto.model;

import static lotto.model.LottoValidator.NUMBERS_SIZE_ERROR;
import static lotto.model.LottoValidator.NUMBER_RANGE_ERROR;
import static lotto.model.LottoValidator.NUMBER_REPEAT_ERROR;
import static lotto.model.LottoValidator.isValid;
import static lotto.model.LottoValidator.isValidRange;
import static lotto.model.LottoValidator.isValidRepeat;
import static lotto.model.LottoValidator.isValidSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    @DisplayName("예외 발생 시 false를 반환")
    @Test
    void is_valid() {
        List<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThat(isValid(numbers1)).isFalse();

        List<Integer> numbers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(isValid(numbers2)).isTrue();
    }

    @DisplayName("중복 숫자가 있으면 예외가 발생한다.")
    @Test
    void repeat_error() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> isValidRepeat(numbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(NUMBER_REPEAT_ERROR);

        numbers.remove(numbers.size() - 1);
        numbers.add(6);
        assertThatCode(() -> isValidRepeat(numbers)).doesNotThrowAnyException();
    }

    @DisplayName("숫자가 범위에 넘어가면 예외가 발생한다.")
    @Test
    void range_error() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 46));
        assertThatThrownBy(() -> isValidRange(numbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(NUMBER_RANGE_ERROR);

        numbers.remove(numbers.size() - 1);
        numbers.add(6);
        assertThatCode(() -> isValidRange(numbers)).doesNotThrowAnyException();

        numbers.remove(numbers.size() - 1);
        numbers.add(0);
        assertThatThrownBy(() -> isValidRange(numbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(NUMBER_RANGE_ERROR);
    }

    @DisplayName("숫자의 개수가 6개 넘어가면 예외가 발생한다.")
    @Test
    void size_error() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> isValidSize(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_SIZE_ERROR);

        numbers.add(8);
        assertThatCode(() -> isValidSize(numbers)).doesNotThrowAnyException();

        numbers.add(9);
        assertThatThrownBy(() -> isValidSize(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_SIZE_ERROR);
    }
}
