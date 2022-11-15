package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {

    @DisplayName("로또 번호의 수가 정해진 크기를 넘어가면 예외 발생")
    @Test
    void validateLottoNumbers_OverSize() {
        List<Integer> numbers = new ArrayList<>();
        for (int size = LottoInfo.SIZE.value(), i = 1; i <= size + 1; i++) {
            numbers.add(i);
        }

        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 수가 정해진 범위를 넘어가면 예외 발생")
    @Test
    void validateLottoNumbers_OutOfRange() {
        int min = LottoInfo.MIN_NUMBER.value();

        List<Integer> numbers = new ArrayList<>();
        for (int size = LottoInfo.SIZE.value(), i = 0; i < size; i++) {
            numbers.add(min - i);
        }

        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 수에 중복이 있으면 예외 발생")
    @Test
    void validateLottoNumbers_OutO() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
