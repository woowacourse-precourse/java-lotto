package lotto.domain;

import static lotto.constant.Constants.UNIT_OF_LOTTO_PURCHASE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Nested
    @DisplayName("사용자가 입력한 문자열이")
    class If_user_input_is {

        @Test
        @DisplayName("숫자가 아닐 경우 예외를 던진다")
        void not_numeric() {
            // given
            String input = "로또게임";

            // when, then
            assertThatThrownBy(() -> new Payment(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.MONEY_IS_ALLOWED_ONLY_NUMERIC.getMessage());
        }

        @Test
        @DisplayName("숫자일 경우 예외를 던지지 않는다")
        void numeric() {
            // given
            String input = String.valueOf(UNIT_OF_LOTTO_PURCHASE);

            // when, then
            assertThatCode(() -> new Payment(input))
                    .doesNotThrowAnyException();
        }
    }

    @Test
    @DisplayName("0원을 입력했을 때 예외를 테스트")
    void when_user_input_is_zero() {
        // given
        int inputMoney = 0;

        // when, then
        assertThatThrownBy(() -> new Payment(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USER_INPUT_MONEY_IS_ZERO.getMessage());
    }

    @Nested
    @DisplayName("입력한 구입 금액이")
    class If_input_value_to_purchase {

        /**
         * 만약 구매 단위가 1원이라면 나머지가 생길 수 없기 때문에 테스트가 항상 통과한다
         */
        @Test
        @DisplayName("규칙에 맞지 않다면 예외를 던진다")
        void does_not_comply_with_rule_then_throw_exception() {
            if (UNIT_OF_LOTTO_PURCHASE == 1) {
                return;
            }

            // given
            int inputMoney = UNIT_OF_LOTTO_PURCHASE - 1;

            // when, then
            assertThatThrownBy(() -> new Payment(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE.getMessage());
        }

        /**
         * 만약 구매 단위가 1원이라면 나머지가 생길 수 없기 때문에 테스트가 항상 통과한다
         */
        @Test
        @DisplayName("규칙에 맞다면 예외를 던지지 않는다")
        void does_comply_with_rule_then_does_not_throw_exception() {
            if (UNIT_OF_LOTTO_PURCHASE == 1) {
                return;
            }

            // given
            int inputMoney = UNIT_OF_LOTTO_PURCHASE;

            // when, then
            assertThatCode(() -> new Payment(inputMoney))
                    .doesNotThrowAnyException();
        }
    }
}
