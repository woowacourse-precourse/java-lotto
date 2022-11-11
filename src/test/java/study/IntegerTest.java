package study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    @DisplayName("공백이 포함된 문자열 parseInt 예외 발생")
    void parseIntTrimTest() {
        String input = "  2  ";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class);
    }
}
