package lotto;

import org.junit.jupiter.api.Test;

import java.io.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class UserInputTest {
    final private String ERROR = "[ERROR]";
    @Test
    void 돈_입력_예외_1() {
        String input = "1100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> UserInput.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_예외_2() {
        String input = "NotaNumber";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> UserInput.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_테스트() {
        String input = "2000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        long a = UserInput.inputMoney();
        assertThat(a).isEqualTo(2000);
    }
}
