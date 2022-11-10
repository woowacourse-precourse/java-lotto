package lotto.domain;

import lotto.domain.validator.ErrorMessageConstant;
import lotto.domain.validator.PaymentValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PaymentTest {
    @Test
    @DisplayName("구입 금액에 따른 로또 발행수 구하기")
    void countOfPurchasedLotto() {
        final Payment payment = new Payment(14000);
        assertThat(payment.countOfPurchasedLotto()).isEqualTo(14);
    }
    
    @Test
    @DisplayName("예외 처리 : 1000 단위가 아닌 경우")
    void erroneousPaymentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(14500))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 0인 경우")
    void isPaymentZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(0))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}
