package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.utils.Validator;

public class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("입력 받은 값이 숫자가 아닐경우 예외가 발생한다")
    @ParameterizedTest(name ="{index} {displayName} input={0} ")
    @ValueSource(strings = {"123k", "k123", "adsdf", "12_3", "123 4"})
    void validateNumber(String input) {
        assertThatThrownBy(() -> validator.isNumberOrNot(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 1000의 배수가 아닐 경우 예외가 발생한다")
    @ParameterizedTest(name ="{index} {displayName} input={0} ")
    @ValueSource(strings = {"1001", "1002", "800", "2100"})
    void validateMultipleOfThousand(String input) {
        assertThatThrownBy(()-> validator.isMultiplesOfThousand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 공백의 문자열일 경우")
    @ParameterizedTest(name = "{displayName}")
    @EmptySource
    void validateEmptyString(String input) {
        assertThatThrownBy(()->validator.isFilledString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
