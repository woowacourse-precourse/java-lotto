package lotto.model.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.vallidator.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    @DisplayName("문자열이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputStringNotNumber() {
        assertThatThrownBy(() -> NumberValidator.validate("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열이 숫자인 경우 예외가 발생하지 않는다.")
    @Test
    void inputStringNumber() {
        assertThatNoException().isThrownBy(() -> NumberValidator.validate("1"));
    }

    @DisplayName("문자열 배열에 숫자가 아닌 문자열이 포함된 경우 예외가 발생한다.")
    @Test
    void inputStringsNotNumber() {
        assertThatThrownBy(() -> NumberValidator.validate("1,2,3,a".split(",")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 배열이 모두 숫자인 경우 예외가 발생하지 않는다.")
    @Test
    void inputStringsNumber() {
        assertThatNoException().isThrownBy(() -> NumberValidator.validate("1,2,3,4".split(",")));
    }
}