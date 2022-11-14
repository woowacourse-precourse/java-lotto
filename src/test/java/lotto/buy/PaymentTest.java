package lotto.buy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
    @DisplayName("로또 구매수")
    void lottoPurchase() {
        Payment payment = new Payment(8000);
        assertThat(payment.purchase()).isEqualTo(8);
        payment = new Payment(19000);
        assertThat(payment.purchase()).isEqualTo(19);
    }
    @Test
    @DisplayName("로또 구매 금액")
    void lottoPurchasePrice() {
        Payment payment = new Payment(8000);
        assertThat(payment.getPay()).isEqualTo(8000);
    }
    @Test
    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외메세지가 출력된다.")
    void createPaymentByWrongNumberForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new Payment(1500))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 1,000원으로 나누어 떨어지는 값을 입력해야합니다.");
    }
}
