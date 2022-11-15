package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentValidatorTest {

    @DisplayName("숫자가 아닌 값을 지불하면 예외 발생")
    @Test
    void validateNumberFormat() {
        String payment = "ass12";
        assertThatThrownBy(() -> PaymentValidator.validateNumberFormat(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
