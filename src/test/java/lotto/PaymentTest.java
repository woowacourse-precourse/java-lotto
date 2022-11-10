package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void createPaymentByWrongNumber() {
        assertThatThrownBy(() -> new Payment(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
