package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberInputValidationTest {
    private BonusNumberInputValidation bonusNumberInputValidation;

    @BeforeEach
    public void initialize() {
        bonusNumberInputValidation = new BonusNumberInputValidation();
    }

    @DisplayName("보너스 번호 입력 시 숫자가 아닌 문자가 입력될 경우, 예외가 발생한다.")
    @Test
    void validateInputIsIntegerTest() {
        assertThatThrownBy(() -> bonusNumberInputValidation.validateInputIsInteger("b"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
