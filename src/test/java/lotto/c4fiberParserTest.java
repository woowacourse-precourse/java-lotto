package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class c4fiberParserTest {
    @DisplayName("String -> int 변환이 불가능하면 0을 반환한다.")
    @Test
    void cantParseIntFromString() {
        assertThat(c4fiberParser.getIntegerFromString("123sfesag"))
                .isEqualTo(0);
    }

    @DisplayName(",로 분리한 문자열 중 하나라도 String -> int 변환이 불가능하면 Collection.emptyList()를 반환한다")
    @Test
    void cantParseAllIntFromString() {
        assertThat(c4fiberParser.getIntegerListFromString("1,a,7,45,22"))
                .isEqualTo(Collections.emptyList());
    }

}
