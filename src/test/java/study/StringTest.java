package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2 을 ,로 split 했을 때 1과 2로 잘 분리되는가")
    void split_테스트_1() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는가")
    void split_테스트_2() {
        String[] split = "1".split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메서드 테스트")
    void substring_테스트() {
        String substring = "(1,2)".substring(1, 4);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 인덱스 외 접근 시 StringIndexOutOfBoundsException이 발생 테스트")
    void IndexOutOfBoundsException_발생_테스트() {
        String test = "abc";
        assertThatThrownBy(() -> test.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 5");
    }
}
