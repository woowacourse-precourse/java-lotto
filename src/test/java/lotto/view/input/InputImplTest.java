package lotto.view.input;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
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
            assertThatThrownBy(input::inputPaymentAmount).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1000원 단위의 금액이 아니면 예외가 발생한다.")
        void case2() {
            //given
            String paymentAmountInput = "2222";
            InputStream in = new ByteArrayInputStream(paymentAmountInput.getBytes());
            System.setIn(in);

            //when //then
            assertThatThrownBy(input::inputPaymentAmount).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1000원 이상의 1000원 단위의 금액이어야 한다.")
        void case3() {
            //given
            String paymentAmountInput = "17000";
            InputStream in = new ByteArrayInputStream(paymentAmountInput.getBytes());
            System.setIn(in);

            //when
            int paymentAmount = input.inputPaymentAmount();

            // then
            assertThat(paymentAmount).isEqualTo(Integer.parseInt(paymentAmountInput));
        }
    }
    @Nested
    @DisplayName("당첨 번호는")
    class isAllowedWinningNumberTest{

        @Test
        @DisplayName("6개 이상의 숫자를 입력하면 예외가 발생한다.")
        void case1() {
            //given
            String winningNumberInput = "1,2,3,4,5,6,7";
            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            //when //then
            assertThatThrownBy(input::inputWinningNumbers).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("같은 숫자를 입력하면 예외가 발생한다.")
        void case2() {
            //given
            String winningNumberInput = "1,2,2,3,4,4";
            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            //when //then
            assertThatThrownBy(input::inputWinningNumbers).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("서로 다른 6개의 숫자를 입력해야 한다.")
        void case3() {
            //given
            String winningNumberInput = "1,2,3,4,5,6";
            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            //when
            List<String> winningNumbers = input.inputWinningNumbers();

            // then
            String[] inputWinningNumbers = winningNumberInput.split(",");
            for (String inputWinningNumber : inputWinningNumbers) {
                assertThat(winningNumbers).contains(inputWinningNumber);
            }
        }

        @Test
        @DisplayName("1~45를 벗어난 숫자를 입력하면 예외가 발생한다.")
        void case4() {
            //given
            String winningNumberInput = "1,3,23,29,45,47";
            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            //when //then
            assertThatThrownBy(input::inputWinningNumbers).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1~45의 숫자를 입력해야 한다.")
        void case5() {
            //given
            String winningNumberInput = "1,4,19,30,41,43";
            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            //when
            List<String> winningNumbers = input.inputWinningNumbers();

            // then
            String[] inputWinningNumbers = winningNumberInput.split(",");
            for (String inputWinningNumber : inputWinningNumbers) {
                assertThat(winningNumbers).contains(inputWinningNumber);
            }
        }
    }


}
