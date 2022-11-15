package lotto;

import lotto.model.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("구입 금액 테스트")
    @Nested
    class Input_PurchaseAmount {
        @DisplayName("1,000원으로 나누어떨어지지 않으면 예외가 발생한다.")
        @Test
        void purchaseAmount() {
            assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(10001))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨 번호 테스트")
    @Nested
    class Input_WinningNumber {
        @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void WinningNumberSizeIsOver() {
            assertThatThrownBy(() -> inputValidator.validateWinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
        @Test
        void WinningNumberSizeIsUnder() {
            assertThatThrownBy(() -> inputValidator.validateWinningNumber(List.of(1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호의 범위가 1~45를 벗어나면 예외가 발생한다.")
        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,99", "0,10,20,30,40,45"})
        void inputWinningNumber4(int a, int b, int c, int d, int e, int f) {
            List<Integer> winningNumber = List.of(a, b, c, d, e, f);
            assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void WinningNumberIsDuplicated() {
            assertThatThrownBy(() -> inputValidator.validateWinningNumber(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("보너스 번호 테스트")
    @Nested
    class Input_BonusNumber {
        @DisplayName("보너스 번호의 범위가 1~45를 벗어나면 예외가 발생한다.")
        @ParameterizedTest
        @CsvSource(value = {"0", "100"})
        void BonusNumberOutOfRange(int bonusNumber) {
            assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber, List.of(1, 2, 3, 4, 5, 6)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호의 숫자가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
        @Test
        void BonusNumberInWinningNumber() {
            assertThatThrownBy(() -> inputValidator.validateBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
