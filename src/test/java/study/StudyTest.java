package study;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

enum StringFormatTest {
    TEST_MESSAGE_STRING("Hello, my name is %s"),
    TEST_MESSAGE_INTEGER("I am %s years old"),
    TEST_MESSAGE_LONG("I am %d years old and I have %,d dollars");

    private final String message;

    StringFormatTest(String message) {
        this.message = message;
    }

    public String getMessage(String additionalMessage) {
        return String.format(message, additionalMessage);
    }

    public String getMessage(int number) {
        return String.format(message, number);
    }

    public String getMessage(int number, long money) {
        return String.format(message, number, money);
    }
}
public class StudyTest {
    @Test
    @DisplayName("enum 메시지에 string format 을 사용해서 문자열을 추가한다.")
    void enum_format_string_integer() {
        assertThat(StringFormatTest.TEST_MESSAGE_STRING.getMessage("James"))
                .isEqualTo("Hello, my name is James");
    }

    @Test
    @DisplayName("enum 메시지에 string format 을 사용해서 숫자를 추가한다.")
    void enum_format_string_string() {
        assertThat(StringFormatTest.TEST_MESSAGE_INTEGER.getMessage(23))
                .isEqualTo("I am 23 years old");
    }

    @Test
    @DisplayName("split 메서드를 사용할때 해당 delimiter 가 없는 경우 테스트")
    void split_test() {
        String line = "123/4123";
        List<String> splitInput = List.of(line.split(","));
        assertThat(splitInput).isEqualTo(List.of(line));
    }

    @Test
    @DisplayName("Integer.parseInt 메서드를 사용할때 trim 이 적용되는지 테스트")
    void parse_test() {
        String line = "1";
        assertThat(Integer.parseInt(line)).isEqualTo(1);
    }

    @Test
    @DisplayName("enum 메시지에 long 을 쉼표와 함께 출력한다.")
    void enum_long_message_test() {
        assertThat(StringFormatTest.TEST_MESSAGE_LONG.getMessage(23, 10000000000L))
                .isEqualTo("I am 23 years old and I have 10,000,000,000 dollars");
    }

    @Test
    @DisplayName("unmodifiableList 정렬하면 에러가 발생한다.")
    void unmodifiableList_test() {
        List<Integer> test = List.of(2,3,1,6,5,4);
        assertThatThrownBy(() -> Collections.sort(test)).isInstanceOf(UnsupportedOperationException.class);
    }
}
