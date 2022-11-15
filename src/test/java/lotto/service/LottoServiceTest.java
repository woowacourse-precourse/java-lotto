package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Nested
    @DisplayName("로또 당첨번호 입력 유효성 검증 테스트")
    class WinningNumberInputValueTest {
        @Test
        @DisplayName("[실패] - 올바르지 않은 형식이 입력된 경우(문자열)")
        void notNumberInput() {
            // given
            final String input = "INVALID";

            // when

            // then
            assertThrows(IllegalStateException.class, () -> LottoService.getWinningNumber(input));
        }

        @Test
        @DisplayName("[실패] - 올바르지 않은 형식이 입력된 경우(문자열포함)")
        void notNumberIsInInput() {
            // given
            final String input = "a,1,2,3,4,5";

            // when

            // then
            assertThrows(IllegalStateException.class, () -> LottoService.getWinningNumber(input));
        }

        @Test
        @DisplayName("[실패] - 올바르지 않은 형식이 입력된 경우(쉼표로 구분되지 않은 경우)")
        void notDividedByCommaInput() {
            // given
            final String input = "1 2 3 4 5 6";

            // when

            // then
            assertThrows(IllegalStateException.class, () -> LottoService.getWinningNumber(input));
        }
    }
}