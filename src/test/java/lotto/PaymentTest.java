package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void createPaymentByWrongNumber() {
        assertThatThrownBy(() -> new Payment(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("0원 입력시 구매할 수 없기에 예외가 발생한다.")
    void createPaymentByZero() {
        assertThatThrownBy(() -> new Payment(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 구매수")
    void lottoPurchase(){
        Payment payment = new Payment(8000);
        assertThat(payment.purchase()).isEqualTo(8);
        payment = new Payment(19000);
        assertThat(payment.purchase()).isEqualTo(19);
    }
}
