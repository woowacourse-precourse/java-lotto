package lotto.view.input;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력시")
class InputImplTest {

    Input input = new InputImpl();

    @Nested
    @DisplayName("로또 구매 금액은")
    class isAllowedPaymentAmountTest {

        @Test
        @DisplayName("1000원보다 작으면 예외가 발생한다.")
        void case1() {
            //given
            String paymentAmountInput = "40";
            InputStream in = new ByteArrayInputStream(paymentAmountInput.getBytes());
            System.setIn(in);

            //when //then
            assertThatThrownBy(input::paymentAmountInput).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1000원보다 커야한다.")
        void case2() {
            //given
            String paymentAmountInput = "2222";
            InputStream in = new ByteArrayInputStream(paymentAmountInput.getBytes());
            System.setIn(in);

            //when
            int paymentAmount = input.paymentAmountInput();

            // then
            assertThat(paymentAmount).isEqualTo(Integer.parseInt(paymentAmountInput));
        }

    }


}
