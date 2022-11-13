package lotto;

import lotto.model.payment.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPaymentWithChangeTest() {
        assertThatThrownBy(() -> new Payment(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 대해 1000원 당 로또 1개를 살 수 있다.")
    @Test
    void getLottoCountTest() {
        assertSimpleTest(() -> {
            Payment payment = new Payment(45000);
            int result = 45;

            assertThat(payment.getLottoCount()).isEqualTo(result);
        });
    }
}
