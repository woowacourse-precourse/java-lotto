package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class c4fiberParserTest {
    @DisplayName("String -> int 변환이 불가능하면 예외가 발생한다.")
    @Test
    void cantParseIntFromString() {
        assertThatThrownBy(() -> c4fiberParser.getIntegerFromString("1233abc24"))
                .isInstanceOf(IllegalArgumentException.class);


    }

    @DisplayName(",로 분리한 문자열 중 하나라도 String -> int 변환이 불가능하면 예외가 발생한다.")
    @Test
    void cantParseAllIntFromString() {
        assertThatThrownBy(() -> c4fiberParser.getIntegerListFromString("123,a13,523"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
