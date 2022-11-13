package lotto;

import lotto.model.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("입력된 값이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputValueByNotInteger() {
        assertThatThrownBy(() -> inputValidator.convertStringIntoInt("AAA"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void purchaseAmount() {
        assertThatThrownBy(() -> inputValidator.isPurchaseAmountValidate(10001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
