package lotto.validator.domain;

import lotto.constants.ErrorMessageConstant;
import lotto.validator.domain.PaymentValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PaymentValidatorTest {
    @Test
    @DisplayName("올바른 지불 금액 입력 시")
    void correctPayment() {
        assertThatNoException()
                .isThrownBy(() -> PaymentValidator.validate(14000));
    }
    
    @Test
    @DisplayName("예외 처리 : 1000 단위가 아닌 경우")
    void erroneousPaymentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PaymentValidator.validate(14500))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 0인 경우")
    void isPaymentZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PaymentValidator.validate(0))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}
