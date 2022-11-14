package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputValidatorTest {

    private UserInputValidator userInputValidator;

    @BeforeEach
    void init() {
        userInputValidator = new UserInputValidator();
    }

    @Test
    @DisplayName("구입금액이 1,000원으로 나누어지지 않을때 예외")
    void amountNotDivisible() {
        assertThatThrownBy(() -> userInputValidator.validateAmountInput("1005"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("구입금액이 숫자가 아닌 문자가 입력될 때 예외")
    void amountNotInteger() {
        assertThatThrownBy(() -> userInputValidator.validateAmountInput("a1000"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
