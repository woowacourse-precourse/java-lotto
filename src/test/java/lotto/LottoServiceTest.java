package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @Nested
    @DisplayName("입력값 유효성 검증 테스트")
    class InputValueTest {
        @Test
        @DisplayName("[실패] - 숫자가 아닌 입력을 받은 경우")
        void notNumberInput() {
            // given
            final String input = "INVALID";

            // when

            // then
            assertThrows(IllegalStateException.class, () -> LottoService.amountInputToInteger(input));
        }

        @Test
        @DisplayName("[실패] - 입력 값이 1000보다 작은 경우")
        void inputIsTooLow() {
            // given
            final String input = "999";

            // when

            // then
            assertThrows(IllegalStateException.class, () -> LottoService.amountInputToInteger(input));
        }
    }
}