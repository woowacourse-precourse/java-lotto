package lotto.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyVerifierTest {
    private final MoneyVerifier moneyVerifier = new MoneyVerifier();

    @Nested
    @DisplayName("숫자가 아닌 값이 입력되었을 때")
    class CheckNumeric {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"abc", "!@#", "   ", "ZXc", "ZXC", "%^&", "?\\"})
        void 숫자가_아닌_값을_테스트한다(String target) {
            assertThatThrownBy(() -> moneyVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    @Nested
    @DisplayName("자료형 범위를 벗어났을 때")
    class CheckOutOfRange {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"-9223372036854775809", "9223372036854775808"})
        void 자료형_범위를_벗어났을때를_테스트한다(String target) {
            assertThatThrownBy(() -> moneyVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.OUT_OF_RANGE);
        }
    }

    @Nested
    @DisplayName("음수가 입력되었을 때")
    class CheckPositive {
        @ParameterizedTest(name = "{0}가 입력되었을 떄")
        @ValueSource(strings = {"-123", "-10000", "-1145534", "-1", "-9223372036854775808"})
        void 음수가_입력되었을때를_테스트한다(String target) {
            assertThatThrownBy(() -> moneyVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_POSITIVE);
        }
    }

    @Nested
    @DisplayName("기준 금액으로 나누어지지 않을 때")
    class CheckDivisible {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"123", "1050", "1500", "11100", "12500", "9223372036854775807"})
        void 기준금액으로_나누어지지_않을때를_테스트한다(String target) {
            assertThatThrownBy(() -> moneyVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_DIVISIBLE);
        }
    }
}