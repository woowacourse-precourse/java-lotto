package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @DisplayName("숫자가 아닌 입력이 있을 경우 예외가 발생한다.")
    @Test
    void validateDigit() {
        assertThatThrownBy(() -> validator.validateDigit("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}