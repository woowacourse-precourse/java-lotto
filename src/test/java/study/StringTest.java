package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"를 `,`로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void 요구사항1_1() {
        String input = "1,2";
        String[] output = input.split(",");

        assertThat(output).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 `,`로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void 요구사항1_2() {
        String input = "1";
        String[] output = input.split(",");

        assertThat(output).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\"값이 주어졌을 때 String의 substring()이 `()`를 제거하고 \"1,2\"를 반환하는지 확인")
    void 요구사항2() {
        String input = "(1,2)";
        String output = input.substring(1, 4);

        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\"값이 주어졌을 때 String의 charAt() 메소드가 올바른 위치의 문자를 가져오는지 확인")
    void 요구사항3_1() {
        String input = "abc";
        char output = input.charAt(1);

        assertThat(output).isEqualTo('b');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 사용할 때 위치 값을 벗어나면 에외가 발생하는지 확인")
    void 요구사항3_2() {
        String input ="abcde";

        assertThatThrownBy(() -> { char output = input.charAt(5); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("range: 5");
    }
}
