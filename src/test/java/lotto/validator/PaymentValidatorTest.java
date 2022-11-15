package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoInfo;
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

    @DisplayName("지불한 금액이 로또를 구매하기에 충분하지 않은 경우 예외 발생")
    @Test
    void validatePayment_LowerPrice() {
        long payment = 0;
        assertThatThrownBy(() -> PaymentValidator.validatePayment(payment, LottoInfo.PRICE.value()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지불한 금액으로 로또를 구매하고 거스름돈이 있는 경우 예외 발생")
    @Test
    void validatePayment_Indivisible() {
        long payment = LottoInfo.PRICE.value() + 1;
        assertThatThrownBy(() -> PaymentValidator.validatePayment(payment, LottoInfo.PRICE.value()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
