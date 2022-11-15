package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @Nested
    @DisplayName("구매금액 입력 테스트")
    class PurchaseAmountInputValueTest {
        @Test
        @DisplayName("[실패] - 숫자가 아닌 입력을 받은 경우")
        void notNumberInput() {
            // given
            final String input = "INVALID";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.amountInputToInteger(input));
        }

        @Test
        @DisplayName("[실패] - 입력 값이 1000보다 작은 경우")
        void inputIsTooLow() {
            // given
            final String input = "999";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.amountInputToInteger(input));
        }

        @Test
        @DisplayName("[실패] - 입력 값이 1000으로 나누어 떨어지지 않는 경우")
        void inputIsNotFallApart() {
            // given
            final String input = "1101";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.amountInputToInteger(input));
        }

        @Test
        @DisplayName("[성공] - 입력값 숫자로 변환 성공")
        void success() {
            // given
            final String input = "11000";

            // when
            final long result = LottoService.amountInputToInteger(input);

            // then
            assertEquals(Long.parseLong(input), result);
        }
    }

    @Nested
    @DisplayName("로또 당첨번호 입력 테스트")
    class WinningNumberInputValueTest {
        @Test
        @DisplayName("[실패] - 올바르지 않은 형식이 입력된 경우(문자열)")
        void notNumberInput() {
            // given
            final String input = "INVALID";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.getWinningNumber(input));
        }

        @Test
        @DisplayName("[실패] - 올바르지 않은 형식이 입력된 경우(문자열포함)")
        void notNumberIsInInput() {
            // given
            final String input = "a,1,2,3,4,5";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.getWinningNumber(input));
        }

        @Test
        @DisplayName("[실패] - 올바르지 않은 형식이 입력된 경우(쉼표로 구분되지 않은 경우)")
        void notDividedByCommaInput() {
            // given
            final String input = "1 2 3 4 5 6";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.getWinningNumber(input));
        }

        @Test
        @DisplayName("[실패] - 당첨번호가 1~45 사이가 아닌 경우")
        void numberIsNotInRange() {
            // given
            final String input = "1,2,3,46,6,7";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.getWinningNumber(input));
        }

        @Test
        @DisplayName("[실패] - 입력중 같은 숫자가 있는 경우")
        void numberHasSameNumber() {
            // given
            final String input = "1,2,3,1,6,7";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.getWinningNumber(input));
        }

        @Test
        @DisplayName("[성공]")
        void success() {
            // given
            final String input = "1,2,3,4,5,6";
            final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            // when
            final Lotto result = LottoService.getWinningNumber(input);

            // then
            assertTrue(lotto.getNumbers().containsAll(result.getNumbers()));
        }
    }

    @Nested
    @DisplayName("로또 보너스 번호 입력 테스트")
    class BonusNumberInputValueTest {

        @Test
        @DisplayName("[실패] - 입력 받은 값이 숫자가 아닌 경우")
        void isNotNumber() {
            // given
            final String input = "INVALID";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.getBonusNumber(input));
        }

        @Test
        @DisplayName("[실패] - 보너스 번호가 1~45 범위가 아닌 경우")
        void isNotInRange() {
            // given
            final String input = "1000";

            // when

            // then
            assertThrows(IllegalArgumentException.class, () -> LottoService.getBonusNumber(input));
        }

        @Test
        @DisplayName("[성공]")
        void success() {
            // given
            final String input = "1";
            final int number = Integer.parseInt(input);

            // when
            final int result = LottoService.getBonusNumber(input);

            // then
            assertEquals(number, result);
        }
    }
}