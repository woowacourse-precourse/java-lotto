package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.utils.Validator;

public class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("입력 받은 값이 숫자가 아닐경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"123k","k123","adsdf","12_3","123 4"})
    void validateNumber(String input) {
        assertThatThrownBy(() -> validator.isNumberOrNot(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
