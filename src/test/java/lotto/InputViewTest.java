package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    final private String ERROR = "[ERROR]";

    @Test
    void 돈_입력_예외_1() {
        String input = "1100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_예외_2() {
        String input = "NotaNumber";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 당첨_번호_입력_예외_1() {
        String input = "나, 5, 6, 7, 가";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_메시지() {
        String input = "1000j";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputView.inputMoney())
                .hasMessageContaining("[ERROR]")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
