package lotto;

import lotto.model.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("구입 금액 테스트")
    @Nested
    class Input_PurchaseAmount {
        @DisplayName("입력된 값이 숫자가 아니라면 예외가 발생한다.")
        @Test
        void inputValueByNotInteger() {
            assertThatThrownBy(() -> inputValidator.convertStringIntoInt("AAA"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

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
        @DisplayName("쉼표 기준으로 입력되지 않으면 예외가 발생한다.")
        @Test
        void inputWinningNumberIsNotDividedIntoComma() {
            assertThatThrownBy(() -> inputValidator.convertStringIntoList("0.1.10.15.20.30"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("쉼표 사이에 숫자 형식으로 입력되지 않으면 예외가 발생한다.")
        @Test
        void inputWinningNumberContainsNotNumberTypeElement() {
            assertThatThrownBy(() -> inputValidator.convertStringIntoList("0,1,10,A,20,30"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("쉼표 사이에 값이 비어있으면 예외가 발생한다.")
        @Test
        void inputWinningNumberContainsBlackElement() {
            assertThatThrownBy(() -> inputValidator.convertStringIntoList("0,1,10,,20,30"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
