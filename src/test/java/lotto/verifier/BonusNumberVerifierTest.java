package lotto.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberVerifierTest {
    private BonusNumberVerifier bonusNumberVerifier = new BonusNumberVerifier();

    @Nested
    @DisplayName("checkNumeric 검증 테스트")
    class CheckNumeric {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"abc", "!@#", "   ", "ZXc", "ZXC", "%^&", "?\\"})
        void 숫자가_아닌_값을_테스트(String target) {
            assertThatThrownBy(() -> bonusNumberVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    @Nested
    @DisplayName("checkOutOtTypeRange 검증 테스트")
    class CheckOutOfTypeRange {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"-9223372036854775809", "9223372036854775808"})
        void 자료형_범위를_벗어났을때를_테스트(String target) {
            assertThatThrownBy(() -> bonusNumberVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    @Nested
    @DisplayName("checkOutOfRange 검증 테스트")
    class CheckOutOfRange {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "-1",
                "0",
                "123213"
        })
        void 지정된_로또_값의_범위를_넘지_않는지_테스트(String target) {
            assertThatThrownBy(() -> bonusNumberVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.OUT_OF_RANGE);
        }
    }
}