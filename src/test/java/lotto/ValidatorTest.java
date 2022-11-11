package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Nested
    @DisplayName("validatePayment method test")
    class paymentValidationTest {

        @Test
        @DisplayName("구입 금액이 정수가 아니면 예외를 던진다.")
        void paymentIsNotInteger() {
            // given
            Validator validator = new Validator();

            // throws
            assertThatThrownBy(() -> validator.validatePayment("not integer")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구입 금액이 0이면 예외를 던진다.")
        void paymentIsZero() {
            // given
            Validator validator = new Validator();

            // throws
            assertThatThrownBy(() -> validator.validatePayment("0")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구입 금액이 음수이면 예외를 던진다.")
        void paymentIsNegative() {
            // given
            Validator validator = new Validator();

            // throws
            assertThatThrownBy(() -> validator.validatePayment("-1000")).isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("구입 금액이 0으로 시작하면 예외를 던진다.")
        void paymentStartsWithZero() {
            // given
            Validator validator = new Validator();

            // throws
            assertThatThrownBy(() -> validator.validatePayment("01000")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구입 금액이 1,000원 단위가 아니면 예외를 던진다.")
        void paymentWithWrongUnit() {
            // given
            Validator validator = new Validator();

            // throws
            assertThatThrownBy(() -> validator.validatePayment("1001")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("올바른 구입 금액이면 예외를 던지지 않는다.")
        void goodPayment() {
            // given
            Validator validator = new Validator();

            // throws
            assertThatNoException().isThrownBy(() -> validator.validatePayment("1000"));
        }
    }

    @Nested
    class winningNumbersValidationTest {

        @Test
        @DisplayName("숫자와 쉼표를 제외한 문자가 있으면 예외를 던진다.")
        void otherCharExceptNumberAndComma() {
            // given
            Validator validator = new Validator();

            // throws
            assertThatThrownBy(() -> validator.validateWinningNumbers("-44,10,13,1,6,a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 당첨 번호들의 형태가 잘못되었습니다.");
        }

        @Test
        void commaAtStartOrEnd() {

        }

        @Test
        void numberStartingWithZero() {

        }

        @Test
        void moreThanSixNumbers() {

        }

        @Test
        void numberOver45() {

        }

        @Test
        void numberDuplication() {

        }

        @Test
        void goodWinningNumbers() {

        }
    }
}