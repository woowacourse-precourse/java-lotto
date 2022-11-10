package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.utils.Validator;

public class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("입력 받은 값이 숫자가 아닐경우 예외가 발생한다")
    @ParameterizedTest(name = "{index} {displayName} input={0} ")
    @ValueSource(strings = {"123k", "k123", "adsdf", "12_3", "123 4"})
    void validateNumber(String input) {
        assertThatThrownBy(() -> validator.isNumberOrNot(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 1000의 배수가 아닐 경우 예외가 발생한다")
    @ParameterizedTest(name = "{index} {displayName} input={0} ")
    @ValueSource(strings = {"1001", "1002", "800", "2100"})
    void validateMultipleOfThousand(String input) {
        assertThatThrownBy(() -> validator.isMultiplesOfThousand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 공백의 문자열일 경우")
    @ParameterizedTest(name = "{displayName}")
    @EmptySource
    void validateEmptyString(String input) {
        assertThatThrownBy(() -> validator.isFilledString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 0일 경우")
    @Test
    void validateIsZero() {
        String input = "0";
        assertThatThrownBy(() -> validator.isZero(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 1과 45사이의 정수가 아닌 경우")
    @ParameterizedTest(name = "{index} {displayName} input={0}")
    @ValueSource(strings = {"0", "46"})
    void validateIsinRange(String input) {
        assertThatThrownBy(() -> validator.isInRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 값이 있는 리스트일 경우")
    @Test
    void validateContainDuplicate() {
        List<Integer> inputs = List.of(1, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> validator.containDuplicate(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
