package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @Nested
    @DisplayName("구매금액 입력 유효성 검증 테스트")
    class PurchaseAmountInputValueTest {
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

        @Test
        @DisplayName("[실패] - 입력 값이 1000으로 나누어 떨어지지 않는 경우")
        void inputIsNotFallApart() {
            // given
            final String input = "1101";

            // when

            // then
            assertThrows(IllegalStateException.class, () -> LottoService.amountInputToInteger(input));
        }

        @Test
        @DisplayName("[성공] - 입력값 숫자로 변환 성공")
        void success() {
            // given
            final String input = "11000";

            // when
            final int result = LottoService.amountInputToInteger(input);

            // then
            assertEquals(Integer.parseInt(input), result);
        }
    }
}