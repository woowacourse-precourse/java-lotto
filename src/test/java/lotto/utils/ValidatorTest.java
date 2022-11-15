package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void isBlank_blankInput_exceptionThrown() {
        assertThatThrownBy(() -> Validator.isBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값이 없습니다. 값을 입력해주세요.");
    }

    @Test
    void isNumber_notNumberInput_exceptionThrown() {
        assertThatThrownBy(() -> Validator.isNumber("100a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 숫자여야 합니다.");
    }

    @Test
    void validate_notCommaInput_Fail() {
        assertThatThrownBy(() -> Validator.isCommaCorrect("1-2-3-4-5-6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 콤마(',')로 숫자를 이어서 입력해야 합니다.");
    }

    @Test
    void validate_NotNumberInput_Fail() {
        assertThatThrownBy(() -> Validator.isAllNumber("1,2,3,4,a,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자여야 합니다.");
    }
}