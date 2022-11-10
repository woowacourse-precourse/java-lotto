package lotto.Validator;

import lotto.validator.BuyAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyAmountValidatorTest {
    @DisplayName("유효하지 않은 구입 금액 입력시 예외가 발생한다.")
    @Test
    void createByInvalidInput() {
        assertThatThrownBy(() -> new BuyAmountValidator().validateInvalidNumber("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void validateIsDivideBy1000() {
        assertThatThrownBy(() -> new BuyAmountValidator().validateDivideBy1000(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void createByNegativeNumber() {
        assertThatThrownBy(() -> new BuyAmountValidator().validatePositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
