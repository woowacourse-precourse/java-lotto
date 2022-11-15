package lotto.ui;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력 금액의 유효성을 검사한다.")
    @Nested
    class InputMoney {

        @DisplayName("숫자가 아닌 문자가 포함 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsNotNumber() {
            assertThatThrownBy(() -> InputValidator.validateInputMoney("1000j"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("9자리 초과의 숫자 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsOverDigits() {
            assertThatThrownBy(() -> InputValidator.validateInputMoney("1000000000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("0으로 시작하는 숫자 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_StartWithZero() {
            assertThatThrownBy(() -> InputValidator.validateInputMoney("01000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨 번호의 유효성을 검사한다.")
    @Nested
    class WinningNumbers {

        @DisplayName("공백 포함 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_ContainSpace() {
            assertThatThrownBy(() -> InputValidator.validateInputWinningNumbers("1,2, 3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자가 아닌 문자 입력 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_HaveNotNumber() {
            assertThatThrownBy(() -> InputValidator.validateInputWinningNumbers("1,2,3,4,5,a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("5개의 숫자 입력 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_HaveNotCorrectSize() {
            assertThatThrownBy(() -> InputValidator.validateInputWinningNumbers("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("보너스 번호의 유효성을 검사한다.")
    @Nested
    class BonusNumber {

        @DisplayName("숫자가 아닌 문자 입력 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsNotNumber() {
            assertThatThrownBy(() -> InputValidator.validateInputBonusNumber("7a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("공백 포함 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_ContainSpace() {
            assertThatThrownBy(() -> InputValidator.validateInputBonusNumber(" 7"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("너무 큰 수 -> 예외 발생")
        @Test
        void should_ThrowIllegalArgumentException_When_IsTooBig() {
            assertThatThrownBy(() -> InputValidator.validateInputBonusNumber("1000000000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}