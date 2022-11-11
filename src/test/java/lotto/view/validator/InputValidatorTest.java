package lotto.view.validator;

import lotto.constants.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputValidatorTest {
    @Test
    @DisplayName("null or empty 가 아닐 시")
    void notNullOrEmpty() {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.validateNullOrEmpty("1"));
    }
    
    @DisplayName("예외 처리 : null or empty 를 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void nullOrEmptyInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateNullOrEmpty(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}