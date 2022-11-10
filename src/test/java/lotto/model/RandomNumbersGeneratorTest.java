package lotto.model;

import static lotto.model.RandomNumbersGenerator.NUMBERS_SIZE_ERROR;
import static lotto.model.RandomNumbersGenerator.isValidSize;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

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

    @Test
    void 중복_수가_있으면_예외(){
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> RandomNumbersGenerator.isValidRepeat(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 있습니다.");

        numbers.remove(numbers.size() - 1);
        numbers.add(6);
        assertThatCode(() -> RandomNumbersGenerator.isValidRepeat(numbers)).doesNotThrowAnyException();
    }
}
