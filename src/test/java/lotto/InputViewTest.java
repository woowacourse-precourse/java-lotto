package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    String error = "[ERROR]";
    String purchase = "개를";
    OutputStream out;
    @BeforeEach
    void 스트림_생성() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 입력_예외() {
        String str = "1001";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        inputView.inputMoney();
        assertThat(out.toString()).contains(error)
                .doesNotContain(purchase);
    }

    @Test
    void 입력_예외_2() {
        String str = "0";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        inputView.inputMoney();
        assertThat(out.toString()).contains(error)
                .doesNotContain(purchase);
    }

    @Test
    void 입력_예외_3() {
        String str = "가";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        inputView.inputMoney();
        assertThat(out.toString()).contains(error)
                .doesNotContain(purchase);
    }

    @Test
    void 정상_입력() {
        String str = "10000";
        String ten = "10개";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        inputView.inputMoney();
        assertThat(out.toString()).contains(ten);
    }
}
