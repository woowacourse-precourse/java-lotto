package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @DisplayName("로또는 6자리여야 한다.")
    @Test
    void validateLottoSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException().isThrownBy(() -> Validation.validateLottoSize(numbers));
    }

    @DisplayName("로또는 6자리가 아닐 경우 예외가 발생한다.")
    @Test
    void validateLottoSize_exception() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validation.validateLottoSize(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_LOTTO_LENGTH);
    }

    @DisplayName("로또 번호에 중복된 번호가 있을 경우 예외가 발생한다.")
    @Test
    void validLottoNumberDuplicate() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> Validation.validLottoNumberDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER);
    }

    @DisplayName("로또 번호는 1에서 45사이의 숫자이다.")
    @Test
    void validNumberRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);
        assertThatNoException().isThrownBy(() -> Validation.validNumberRange(numbers));

    }

    @DisplayName("로또 번호는 1에서 45사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void validNumberRange_exception() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> Validation.validNumberRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("문자가 포함되어 있을 경우 예외가 발생한다.")
    @Test
    void validIsDigit() {
        String number = "2*";
        assertThatThrownBy(() -> Validation.validIsDigit(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER);
    }
}