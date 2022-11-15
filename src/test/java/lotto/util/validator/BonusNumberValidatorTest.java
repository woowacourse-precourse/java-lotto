package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {
    @DisplayName("보너스 숫자를 뽑는 기능 예외 테스트")
    @Test
    void createBonusNumber() {
        String numbers = "1,2,3,4,5,6";

        assertThatThrownBy(() -> new BonusNumberValidator(numbers, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new BonusNumberValidator(numbers, "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new BonusNumberValidator(numbers, "--"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}