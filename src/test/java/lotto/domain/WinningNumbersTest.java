package lotto.domain;

import lotto.utils.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("당첨 번호, 보너스 번호 입력 유효성 검사")
class WinningNumbersTest {
    @Nested
    @DisplayName("당첨번호 유효성 검사")
    class WinningNumberTest {
        @Test
        @DisplayName("당첨번호를 쉼표로 구분해 6개가 나오지 않으면 예외발생")
        void separateWinningNumberExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,2,3,4,5,6,7", "3"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.WINNING_NUMBER_HAS_SIX_ELEMENT);
        }

        @Test
        @DisplayName("당첨번호를 쉼표로 구분해 문자가 있으면 예외발생")
        void winningNumberOnlyNumberExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,2,3,4,5, 6", "3"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_ONLY_NUMBERS);
        }

        @Test
        @DisplayName("당첨번호 중 1미만인 숫자가 있으면 예외발생")
        void winningNumberMinRangeExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,2,3,0,5,6", "3"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }

        @Test
        @DisplayName("당첨번호 중 45를 넘어가는 숫자가 있으면 예외발생")
        void winningNumberMaxRangeExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,50,3,4,5,6", "3"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }
    }

    @Nested
    @DisplayName("보너스 번호 유효성 검사")
    class BonusNumberTest {
        @Test
        @DisplayName("보너스 번호에 문자가 입력되면 예외발생")
        void bonusNumberCharacterExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,2,3,4,5,6", ""));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_ONLY_NUMBERS);
        }

        @Test
        @DisplayName("보너스 번호가 1미만이면 예외발생")
        void bonusNumberMinRangeExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,2,3,4,5,6", "0"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }

        @Test
        @DisplayName("보너스 번호가 45초과면 예외발생")
        void bonusNumberMaxRangeExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,2,3,4,5,6", "46"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.LOTTO_OUT_OF_RANGE);
        }

        @Test
        @DisplayName("보너스 번호가 당첨번호와 중복되면 예외발생")
        void bonusNumberDuplicateExceptionTest() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> new WinningNumbers("1,2,3,4,5,6", "6"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.BONUS_NUMBER_DUPLICATE);
        }
    }

}