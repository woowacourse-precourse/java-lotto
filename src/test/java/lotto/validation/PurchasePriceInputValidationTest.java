package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasePriceInputValidationTest {
    private PurchasePriceInputValidation purchasePriceInputValidation;

    @BeforeEach
    public void initialize() {
        purchasePriceInputValidation = new PurchasePriceInputValidation();
    }

    @DisplayName("구입금액 입력 시 숫자가 아닌 문자가 있을 경우, 예외가 발생한다.")
    @Test
    void validateConsistedOnlyOfNumbersTest() {
        assertThatThrownBy(() -> purchasePriceInputValidation.validateConsistedOnlyOfNumbers("800a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000으로 나누어떨어지지 않을 경우, 예외가 발생한다.")
    @Test
    void validateDividedByThousandTest() {
        assertThatThrownBy(() -> purchasePriceInputValidation.validateDividedByThousand("8500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
