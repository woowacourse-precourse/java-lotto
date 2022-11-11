package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

    @Test
    @DisplayName("split 메서드 사용법 확인")
    void basicSplitTest() {
        String input = "1,2";
        String[] splitInput = input.split(",");
        assertThat(splitInput).containsExactly("1", "2");
    }

    @Test
    @DisplayName("하나의 원소만 있을때 split 결과 테스트")
    void oneElementSplitTest() {
        String input = "1";
        String[] splitInput = input.split(",");
        assertThat(splitInput).containsOnly("1");
    }

    @Test
    @DisplayName("구분자로 끝나는 문자열 split 결과 테스트")
    void finishWithDelimiterSplitTest() {
        String input = "1,2,";
        String[] splitInput = input.split(",");
        assertThat(splitInput)
                .isNotEmpty()
                .hasSize(2)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("구분자가 연속해서 나오는 경우 split 결과 테스트")
    void continuousDelimiterTest() {
        String input = "1,2,,,3";
        String[] splitInput = input.split(",");
        assertThat(splitInput)
                .isNotEmpty()
                .hasSize(5)
                .containsExactly("1", "2", "", "", "3");
    }

    @Test
    @DisplayName("substring 메서드 사용법 확인")
    void subStringTest() {
        String input = "(1,2)";
        String part = input.substring(1, 4);
        assertThat(part).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0, a", "1, b", "2, c"})
    @DisplayName("charAt 메서드 사용법 확인")
    void charAtTest(int index, char character) {
        String input = "abc";
        assertThat(input.charAt(index)).isEqualTo(character);
    }

    @Test
    @DisplayName("charAt 잘못된 범위의 인덱스 사용시 예외 발생")
    void charAtIndexOutOfBoundsException() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
