package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @DisplayName("readInteger() 값 테스트")
    @Test
    void readIntegerTest() {
        InputStream in = new ByteArrayInputStream("1000".getBytes());
        System.setIn(in);

        assertThat(Input.readInteger()).isEqualTo(1000).isInstanceOf(Integer.class);
    }

    @DisplayName("readLong() 값 테스트")
    @Test
    void readLongTest() {
        InputStream in = new ByteArrayInputStream("1000".getBytes());
        System.setIn(in);

        assertThat(Input.readLong()).isEqualTo(1000).isInstanceOf(Long.class);
    }

    @DisplayName("숫자가 아닌 값을 입력 시 readInteger() 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aaaa", "1000a", "a1000", "10a00"})
    void readIntegerExceptionTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> Input.readInteger())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("숫자가 아닌 값을 입력 시 readLong() 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aaaa", "1000a", "a1000", "10a00"})
    void readLongExceptionTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> Input.readLong())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자로 나눠지는 리스트 입력 값 테스트")
    @Test
    void readListTest() {
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);

        assertThat(Input.readListInteger(",")).contains(1,2,3,4,5,6);
    }

}
