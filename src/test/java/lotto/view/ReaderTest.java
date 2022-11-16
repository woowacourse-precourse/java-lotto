package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReaderTest {

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void readOneNumber() {
        Reader reader = new Reader();

        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> reader.readOneNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자를 잘못 입력하면 예외가 발생한다.")
    @Test
    void readNumbers() {
        Reader reader = new Reader();

        String input = "1,2,3/4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> reader.readNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

}