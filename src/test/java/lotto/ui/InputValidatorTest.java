package lotto.ui;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @DisplayName("입력 금액의 유효성을 검사한다.")
    @Nested
    class inputMoney {

        @DisplayName("숫자가 아닌 문자가 포함 -> 예외 발생")
        @Test
        void NotNumber() {
            assertThatThrownBy(() -> InputValidator.checkInputMoney("1000j"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("9자리 초과의 숫자 -> 예외 발생")
        @Test
        void Over9Digits() {
            assertThatThrownBy(() -> InputValidator.checkInputMoney("1000000000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}