package lotto.model;

import static lotto.model.NumbersValidator.NUMBER_RANGE_ERROR;
import static lotto.model.NumbersValidator.NUMBER_REPEAT_ERROR;
import static lotto.model.NumbersValidator.isValidRange;
import static lotto.model.NumbersValidator.isValidRepeat;
import static lotto.model.NumbersValidator.NUMBERS_SIZE_ERROR;
import static lotto.model.NumbersValidator.isValidSize;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersValidatorTest {


    @Test
    void 중복_수가_있으면_예외() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> isValidRepeat(numbers)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(NUMBER_REPEAT_ERROR);

        numbers.remove(numbers.size() - 1);
        numbers.add(6);
        assertThatCode(() -> isValidRepeat(numbers)).doesNotThrowAnyException();
    }

    @Test
    void 숫자_범위_예외() {
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

    @Test
    void 번호가_6개아니면_예외() {
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
