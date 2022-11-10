package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {
    @Test
    @DisplayName("구입 금액에 따른 로또 발행수 구하기")
    void countOfPurchasedLotto() {
        final Payment payment = new Payment(14000);
        assertThat(payment.countOfPurchasedLotto()).isEqualTo(14);
    }
}
