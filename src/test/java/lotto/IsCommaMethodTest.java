package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.isComma;
import static org.assertj.core.api.Assertions.assertThat;

class IsCommaMethodTest {
    @DisplayName("쉼표의 경우 true를 반환한다.")
    @Test
    void isCommaMethodTest() {
        char character = ',';
        assertThat(isComma(character)).isEqualTo(true);
    }

    @DisplayName("쉼표를 제외한 모든 경우 false를 반환한다.")
    @Test
    void isCommaMethodExceptionTest() {
        for (char asciicode = 0; asciicode < 256; asciicode++) {
            if (asciicode == ',') continue;
            assertThat(isComma(asciicode)).isEqualTo(false);
        }
    }
}