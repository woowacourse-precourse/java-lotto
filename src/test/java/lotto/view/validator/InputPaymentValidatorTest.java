package lotto.view.validator;

import lotto.domain.validator.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputPaymentValidatorTest {
    @Test
    @DisplayName("올바른 payment 입력 시")
    void correctPaymentInput() {
        assertThatNoException()
                .isThrownBy(() -> InputPaymentValidator.validate("14000"));
    }
    
    @DisplayName("예외 처리 : null or empty 를 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void nullOrEmptyInputException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputPaymentValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}