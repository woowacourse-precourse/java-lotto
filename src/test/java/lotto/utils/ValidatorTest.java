package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void isBlank_blankInput_exceptionThrown() {
        assertThatThrownBy(() -> Validator.isBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액을 입력해주세요.");
    }

    @Test
    void isNumber_notNumberInput_exceptionThrown() {
        assertThatThrownBy(() -> Validator.isNumber("100a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 숫자여야 합니다.");
    }
}