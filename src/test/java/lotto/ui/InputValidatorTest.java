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

        @DisplayName("0으로 시작하는 숫자 -> 예외 발생")
        @Test
        void StartWithZero() {
            assertThatThrownBy(() -> InputValidator.checkInputMoney("01000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨 번호의 유효성을 검사한다.")
    @Nested
    class WinningNumbers {

        @DisplayName("공백 포함 -> 예외 발생")
        @Test
        void NotNumber() {
            assertThatThrownBy(() -> InputValidator.checkInputWinningNumbers("1,2, 3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자가 아닌 문자 입력 -> 예외 발생")
        @Test
        void Over9Digits() {
            assertThatThrownBy(() -> InputValidator.checkInputWinningNumbers("1,2,3,4,5,a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("5개의 숫자 입력 -> 예외 발생")
        @Test
        void HaveLengthOf5() {
            assertThatThrownBy(() -> InputValidator.checkInputWinningNumbers("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("보너스 번호의 유효성을 검사한다.")
    @Nested
    class BonusNumber {

        @DisplayName("숫자가 아닌 문자 입력 -> 예외 발생")
        @Test
        void NotNumber() {
            assertThatThrownBy(() -> InputValidator.checkInputBonusNumber("7a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("공백 포함 -> 예외 발생")
        @Test
        void HaveSpace() {
            assertThatThrownBy(() -> InputValidator.checkInputBonusNumber(" 7"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("공백 포함 -> 예외 발생")
        @Test
        void Over9Digits() {
            assertThatThrownBy(() -> InputValidator.checkInputBonusNumber("1000000000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}