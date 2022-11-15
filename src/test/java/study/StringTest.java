package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("split 메서드가 regex를 기준으로 주어진 값을 분리")
    @Test
    void splitTest1() {
        final String input = "1,2";
        final String[] result = input.split(",");

        assertThat(result).contains("1", "2");
    }

    @DisplayName("split 메서드 사용 시 주어진 값에 regex가 없는 경우 값이 그대로 배열에 담겨 반환")
    @Test
    void splitTest2() {
        final String input = "1";
        final String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring 메서드로 주어진 값의 특정 구간을 추출해 반환")
    @Test
    void substringTest() {
        final String input = "(1,2)";
        final String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드로 특정 위치의 문자 가져오기")
    @Test
    void charAtTest() {
        final String input = "abc";
        final char specifiedCharacter = input.charAt(0);
        assertThat(specifiedCharacter).isEqualTo('a');
    }

    @DisplayName("charAt 메서드로 특정 위치의 문자를 찾을 때 위치 값이 문자열 길이 이상일 경우 예외 발생")
    @Test
    void illegalArgumentExceptionTest() {
        final String input = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(5))
                        .withMessageMatching("String index out of range: \\d+");
    }
}
