package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split_메서드가_regex를_기준으로_주어진_값을_분리() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("1", "2");
    }

    @Test
    void split_메서드_사용_시_주어진_값에_regex가_없는_경우_값이_그대로_배열에_담겨_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_메서드로_주어진_값의_특정_구간을_추출해_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드로 특정 위치의 문자 가져오기")
    @Test
    void charAtTest() {
        String input = "abc";
        char specifiedCharacter = input.charAt(0);
        assertThat(specifiedCharacter).isEqualTo('a');
    }

    @DisplayName("charAt 메서드로 특정 위치의 문자를 찾을 때 위치 값이 문자열 길이 이상일 경우 예외 발생")
    @Test
    void illegalArgumentExceptionTest() {
        String input = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(5))
                        .withMessageMatching("String index out of range: \\d+");
    }
}
