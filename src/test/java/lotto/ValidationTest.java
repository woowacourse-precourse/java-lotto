package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    Validation validation;

    @BeforeEach
    void initialize() {
        validation = new Validation();
    }

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 천_단위가_아님() {
        assertThatThrownBy(() -> validation.validatePrice("1234")).isInstanceOf(IllegalArgumentException.class);
    }

}
