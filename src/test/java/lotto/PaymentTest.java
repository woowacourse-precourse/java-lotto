package lotto;

import lotto.domain.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {
    @DisplayName("입력 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputPaymentByNotNumber(){
        assertThatThrownBy(() -> new Payment("abc123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void inputPaymentByNotPositiveNumber(){
        assertThatThrownBy(() -> new Payment("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력 금액이 로또 금액(1000원) 단위가 아니면 예외가 발생한다.")
    @Test
    void inputPaymentByNotLottoPriceUnit(){
        assertThatThrownBy(() -> new Payment("2500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 정상적인 경우")
    @Test
    void inputPaymentTest(){
        assertThatCode(()->new Payment("3000"))
                .doesNotThrowAnyException();
    }
}
