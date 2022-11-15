package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringUtilsTest {
    @DisplayName("문자열이 빈칸인 경우 true를 반환한다.")
    @Test
    public void validateBlank() {
        String blankInput = "";
        assertThat(StringUtils.isBlank(blankInput))
                .isTrue();
    }

    @DisplayName("문자열이 null인 경우 true를 반환한다.")
    @Test
    public void validateNull() {
        String blankInput = null;
        assertThat(StringUtils.isBlank(blankInput))
                .isTrue();
    }

    @DisplayName("문자열이 빈칸이나 null이 아닌 경우 false를 반환한다.")
    @Test
    public void goodInput() {
        String blankInput = null;
        assertThat(StringUtils.isBlank(blankInput))
                .isTrue();
    }
}