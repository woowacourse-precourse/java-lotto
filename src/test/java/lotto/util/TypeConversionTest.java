package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TypeConversionTest {

    @DisplayName("입력값에 숫자만 있는지 확인 - 숫자만 존재하지 않음")
    @Test
    void stringToIntNotOnlyNumber() {
        // given
        String input = "8000j";

        // expected
        assertThatThrownBy(() -> TypeConversion.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 숫자만 있는지 확인 - 숫자만 존재함")
    @Test
    void stringToIntOnlyNumber() {
        // given
        String input = "8000";

        // expected
        TypeConversion.stringToInt(input);
    }
}