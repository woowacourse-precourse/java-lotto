package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

enum StringFormatTest {
    TEST_MESSAGE_STRING("Hello, my name is %s"),
    TEST_MESSAGE_INTEGER("I am %s years old");
    private final String message;
    StringFormatTest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String additionalMessage) {
        return String.format(message, additionalMessage);
    }
    public String getMessage(int number) {
        return String.format(message, number);
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
}
